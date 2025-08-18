package hexlet.code.utils;

import hexlet.code.model.User;
import hexlet.code.repository.TaskRepository;
import hexlet.code.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserUtils {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public User getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        var email = authentication.getName();
        return userRepository.findByEmail(email).get();
    }

//    public boolean isAssignee(long taskId) {
//        var taskAssigneeEmail = taskRepository.findById(taskId).get().getAssignee().getEmail();
//        var authentication = SecurityContextHolder.getContext().getAuthentication();
//        return taskAssigneeEmail.equals(authentication.getName());
//    }

    public boolean isAuthenticated(Long userId) {
        try {
            var auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated() || auth.getName() == null) {
                return false;
            }
            Optional<User> userOpt = userRepository.findById(userId);
            if (userOpt.isEmpty()) {
                return false;
            }
            var user = userOpt.get();
            return auth.getName().equals(user.getEmail());
        } catch (Exception e) {
            return false;
        }
    }


    public User getTestUser() {
        return userRepository.findByEmail("hexlet@example.com")
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
