package pl.ug.virtualofficebackend.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.office.internal.OfficeServiceImpl;
import pl.ug.virtualofficebackend.domain.room.entity.Room;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;
import pl.ug.virtualofficebackend.domain.workstation.internal.WorkstationServiceImpl;

import java.util.ArrayList;

@Controller
public class AdminController {

    @Autowired
    OfficeServiceImpl officeService;


    @GetMapping("/admin")
    public String start(Model model) {

        Office newOffice = new Office();
        newOffice.setDecorations(new ArrayList<Decoration>());
        newOffice.setRooms(new ArrayList<Room>());
        newOffice.setWorkstations(new ArrayList<Workstation>());


        User newManager = new User();
        newManager.setOffice(newOffice);

        model.addAttribute("newManager", newManager);

        return "admin";
    }
}
