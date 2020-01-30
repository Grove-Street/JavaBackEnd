package pl.ug.virtualofficebackend.api.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.room.entity.Room;
import pl.ug.virtualofficebackend.domain.security.boundary.UserSecurityService;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

@Controller
public class AdminController {
    private OfficeService officeService;
    private UserService userService;
    private UserSecurityService userSecurityService;

    @Autowired
    public AdminController(
        OfficeService officeService, 
        UserService userService, 
        UserSecurityService userSecurityService) {
            this.officeService = officeService;
            this.userService = userService;
            this.userSecurityService = userSecurityService;
    }

    @GetMapping("/admin")
    public String start(Model model, @RequestHeader(name="Authorization") String token) {
        User user = userSecurityService.getUser(token);
        System.out.println(user);

        Office newOffice = new Office();

        User newManager = new User();
        newManager.setOffice(newOffice);

        model.addAttribute("newManager", newManager);

        return "admin";
    }

    @PostMapping("/admin/new_manager/add")
    public String addManager(@Valid User newManager, BindingResult errors) {
        if(errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            return "admin";
        }

        Office officeToAdd = new Office();
        officeToAdd.setDecorations(new ArrayList<Decoration>());
        officeToAdd.setRooms(new ArrayList<Room>());
        officeToAdd.setWorkstations(new ArrayList<Workstation>());
        officeToAdd.setUsers(new ArrayList<User>());
        officeToAdd.setName(newManager.getOffice().getName());

        System.out.println("\n\n " + officeToAdd + "\n\n");

        officeService.save(officeToAdd);
        newManager.setOffice(officeToAdd);
        userService.save(newManager);
        officeToAdd.getUsers().add(newManager);
        officeService.save(officeToAdd);

        return "redirect:/admin";
    }
}
