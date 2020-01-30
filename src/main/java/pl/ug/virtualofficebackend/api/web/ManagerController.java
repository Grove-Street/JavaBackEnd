package pl.ug.virtualofficebackend.api.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.workstation.boundary.WorkstationService;

@Controller
public class ManagerController {
    private UserService userService;
    private WorkstationService workstationService;

    @Autowired
    public ManagerController(UserService userService, WorkstationService workstationService) {
        this.userService = userService;
        this.workstationService = workstationService;
    }

    private User getUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();//(User) auth.getPrincipal();
        return user;
    }

    @GetMapping("/manager")
    public String panel(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("newUser", new User());
        model.addAttribute("workstations", workstationService.getAll());
        model.addAttribute("manager", getUser());
        return "manager";
    }

    @PostMapping("/manager/add")
    public String panel(@Valid User user, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("users", userService.getAll());
            model.addAttribute("newUser", user);
            model.addAttribute("manager", getUser());
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
        userToAdd.setOffice(getUser().getOffice());
        userService.save(userToAdd);

        return "redirect:/manager";
    }
}
