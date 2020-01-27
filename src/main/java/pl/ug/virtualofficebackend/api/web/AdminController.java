package pl.ug.virtualofficebackend.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.office.internal.OfficeServiceImpl;
import pl.ug.virtualofficebackend.domain.room.entity.Room;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.user.internal.UserServiceImpl;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;
import pl.ug.virtualofficebackend.domain.workstation.internal.WorkstationServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class AdminController {

    @Autowired
    OfficeServiceImpl officeService;

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/admin")
    public String start(Model model) {

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
