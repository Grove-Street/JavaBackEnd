package pl.ug.virtualofficebackend.api.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;

@RestController
public class LoggingController {

    private UserService userService;

    @Autowired
    public LoggingController(UserService userService) {
        this.userService = userService;
    }

}
