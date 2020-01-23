package pl.ug.virtualofficebackend.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.user.internal.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/admin")
    public String panel(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping("/admin/add")
    public String panel(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("users", userService.getAll());
            model.addAttribute("newUser", user);
            return "admin";
        }

        User userToAdd = new User();
        userToAdd.setName(user.getName());
        userToAdd.setSecondName(user.getSecondName());
        userToAdd.setSurname(user.getSurname());
        userToAdd.setEmail(user.getEmail());
        userToAdd.setCountry(user.getCountry());
        userToAdd.setUsername(user.getUsername());
        userToAdd.setWorkstation(user.getWorkstation());
        userToAdd.setOffice(new Office()); // loggedManager.getOffice()
        userService.save(userToAdd);

        return "redirect:/admin";
    }
}
