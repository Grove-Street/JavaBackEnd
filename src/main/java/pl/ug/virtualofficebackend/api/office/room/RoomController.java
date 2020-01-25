package pl.ug.virtualofficebackend.api.office.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.room.boundary.RoomService;
import pl.ug.virtualofficebackend.domain.room.entity.Room;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/son"}, produces = {"application/json"})
    public Room post(@RequestBody Room room) {
        return this.roomService.save(room);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<Room> post(@RequestBody @Valid List<Room> rooms) {
        return this.roomService.save(rooms);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<Room> get() {
        return this.roomService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Room get(@PathVariable Long id) {
        return this.roomService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public Room put(@PathVariable Long id, @RequestBody Room room) {
        return this.roomService.put(id, room);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.roomService.delete(id);
    }
}
