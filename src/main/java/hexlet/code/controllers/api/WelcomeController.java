package hexlet.code.controllers.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

@GetMapping(path = "/welcome")
    public String welcome() {
        return "Welcome to Spring!";
    }
}
