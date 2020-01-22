package pl.ug.virtualofficebackend.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.internal.UserServiceImpl;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/admin")
    public String panel(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin";
    }
}
