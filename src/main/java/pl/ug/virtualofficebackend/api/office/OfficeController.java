package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.decoration.boundary.DecorationService;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.room.boundary.RoomService;
import pl.ug.virtualofficebackend.domain.room.entity.Room;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.workstation.boundary.WorkstationService;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {
    private OfficeService officeService;
    private WorkstationService workstationService;
    private UserService userService;
    private RoomService roomService;
    private DecorationService decorationService;

    @Autowired
    public OfficeController(
            OfficeService officeService,
            WorkstationService workstationService,
            UserService userService,
            RoomService roomService,
            DecorationService decorationService) {
        this.officeService = officeService;
        this.workstationService = workstationService;
        this.userService = userService;
        this.roomService = roomService;
        this.decorationService = decorationService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public Office post(@RequestBody Office office) {
        return this.officeService.save(office);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<Office> post(@RequestBody @Valid List<Office> offices) {
        return this.officeService.save(offices);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<Office> get() {
        return this.officeService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/workstations", method = RequestMethod.GET, produces = {"application/json"})
    public List<Workstation> getWorkstations(@PathVariable Long id) {
        return this.workstationService.getByOffice(this.officeService.get(id));
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/users", method = RequestMethod.GET, produces = {"application/json"})
    public List<User> getUsers(@PathVariable Long id) {
        return this.userService.getByOffice(this.officeService.get(id));
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/availableUsers", method = RequestMethod.GET, produces = {"application/json"})
    public List<User> getAvailableUsers(@PathVariable Long id) {
        return this.userService.getUsersWithoutWorkstation(this.officeService.get(id));
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/rooms", method = RequestMethod.GET, produces = {"application/json"})
    public List<Room> getRooms(@PathVariable Long id) {
        return this.roomService.getByOffice(this.officeService.get(id));
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}/decorations", method = RequestMethod.GET, produces = {"application/json"})
    public List<Decoration> getDecorations(@PathVariable Long id) {
        return this.decorationService.getByOffice(this.officeService.get(id));
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public Office put(@PathVariable Long id, @RequestBody Office office) {
        return this.officeService.put(id, office);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.officeService.delete(id);
    }
}
