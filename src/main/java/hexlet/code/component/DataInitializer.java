package hexlet.code.component;

import hexlet.code.controllers.api.LabelController;
import hexlet.code.controllers.api.TaskStatusController;
import hexlet.code.dto.label.LabelCreateDTO;
import hexlet.code.dto.taskStatus.TaskStatusCreateDTO;
import hexlet.code.model.User;
import hexlet.code.service.imlementations.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserServiceImpl userService;

    private final TaskStatusController taskStatusController;

    private final LabelController labelController;


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
