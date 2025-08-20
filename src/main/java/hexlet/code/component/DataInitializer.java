package hexlet.code.component;

import hexlet.code.controllers.api.LabelController;
import hexlet.code.controllers.api.TaskStatusController;
import hexlet.code.dto.label.LabelCreateDTO;
import hexlet.code.dto.taskStatus.TaskStatusCreateDTO;
import hexlet.code.model.User;
import hexlet.code.service.imlementations.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

//    @Autowired
//    private final UserRepository userRepository;
//
//    @Autowired
//    private final UserMapper userMapper;
//
//    @Autowired
//    private UsersController usersController;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TaskStatusController taskStatusController;

    @Autowired
    private LabelController labelController;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        var email = "hexlet@example.com";
        var userData = new User();
        userData.setEmail(email);
        userData.setPasswordDigest("qwerty");
        userService.create(userData);

        List<TaskStatusCreateDTO> taskStatuses = Arrays.asList(
                new TaskStatusCreateDTO("Draft", "draft"),
                new TaskStatusCreateDTO("ToReview", "to_review"),
                new TaskStatusCreateDTO("ToBeFixed", "to_be_fixed"),
                new TaskStatusCreateDTO("ToPublish", "to_publish"),
                new TaskStatusCreateDTO("Published", "published")
        );
        taskStatuses.forEach(taskStatusController::create);

        List<LabelCreateDTO> labels = Arrays.asList(
                new LabelCreateDTO("feature"),
                new LabelCreateDTO("bug")
        );
        labels.forEach(labelController::create);
    }
}
