package pl.ug.virtualofficebackend.api.office.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.roomType.boundary.RoomTypeService;
import pl.ug.virtualofficebackend.domain.roomType.entity.RoomType;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/roomType")
public class RoomTypeController {
    private RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public RoomType post(@RequestBody RoomType roomType) {
        return this.roomTypeService.save(roomType);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<RoomType> post(@RequestBody @Valid List<RoomType> roomTypes) {
        return this.roomTypeService.save(roomTypes);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<RoomType> get() {
        return this.roomTypeService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public RoomType get(@PathVariable Long id) {
        return this.roomTypeService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public RoomType put(@PathVariable Long id, @RequestBody RoomType roomType) {
        return this.roomTypeService.put(id, roomType);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.roomTypeService.delete(id);
    }
}
