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
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;
import pl.ug.virtualofficebackend.domain.workstation.internal.WorkstationServiceImpl;

import javax.validation.Valid;

@Controller
public class ManagerController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    WorkstationServiceImpl workstationService;

    User manager = new User(); // logedManager //
    // Potrzebne dane zalogowanego user'a jako manager od Spring Security

    @GetMapping("/manager")
    public String panel(Model model) {

        manager = userService.get(0);

        model.addAttribute("users", userService.getAll());
        model.addAttribute("newUser", new User());
        model.addAttribute("workstations", workstationService.getAll());
        model.addAttribute("manager", manager);
        return "manager";
    }

    @PostMapping("/manager/add")
    public String panel(@Valid User user, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("users", userService.getAll());
            model.addAttribute("newUser", user);
            model.addAttribute("manager", manager);
            model.addAttribute("workstations", workstationService.getAll());
            return "manager";
        }

        User userToAdd = new User();
        userToAdd.setName(user.getName());
        userToAdd.setSecondName(user.getSecondName());
        userToAdd.setSurname(user.getSurname());
        userToAdd.setEmail(user.getEmail());
        userToAdd.setCountry(user.getCountry());
        userToAdd.setUsername(user.getUsername());
        userToAdd.setWorkstation(user.getWorkstation());
        userToAdd.setOffice(manager.getOffice()); // loggedManager.getOffice()
        userService.save(userToAdd);

        return "redirect:/manager";
    }
}
