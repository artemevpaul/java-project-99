package hexlet.code.component;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.controllers.api.UsersController;
import hexlet.code.mapper.UserMapper;
import hexlet.code.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private UsersController usersController;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        var admin = new UserCreateDTO();
        admin.setEmail("hexlet@example.com");
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setPassword("qwerty");
        usersController.create(admin);
    }
}
