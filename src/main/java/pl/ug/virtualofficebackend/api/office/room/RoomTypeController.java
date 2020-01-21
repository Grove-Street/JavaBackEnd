package pl.ug.virtualofficebackend.api.office.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.roomType.boundary.RoomTypeService;
import pl.ug.virtualofficebackend.domain.roomType.entity.RoomType;

import java.util.List;

@RestController
public class RoomTypeController {
    private RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @CrossOrigin
    @PostMapping("/api/roomType")
    public ResponseEntity<RoomType> post(@RequestBody RoomType roomType) {
        return new ResponseEntity<>(this.roomTypeService.save(roomType), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/roomType")
    public ResponseEntity<List<RoomType>> get() {
        return new ResponseEntity<>(this.roomTypeService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/roomType/{id}")
    public ResponseEntity<RoomType> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.roomTypeService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/roomType/{id}")
    public ResponseEntity<RoomType> put(@PathVariable Long id, @RequestBody RoomType roomType) {
        if (this.roomTypeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.roomTypeService.put(id, roomType), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/roomType/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.roomTypeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.roomTypeService.delete(id);

        return new ResponseEntity<>("Room type deleted", HttpStatus.OK);
    }
}
