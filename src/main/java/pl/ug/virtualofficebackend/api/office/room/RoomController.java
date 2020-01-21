package pl.ug.virtualofficebackend.api.office.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.room.boundary.RoomService;
import pl.ug.virtualofficebackend.domain.room.entity.Room;

import java.util.List;

@RestController
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @CrossOrigin
    @PostMapping("/api/room")
    public ResponseEntity<Room> post(@RequestBody Room room) {
        return new ResponseEntity<>(this.roomService.save(room), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/room")
    public ResponseEntity<List<Room>> get() {
        return new ResponseEntity<>(this.roomService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/room/{id}")
    public ResponseEntity<Room> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.roomService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/room/{id}")
    public ResponseEntity<Room> put(@PathVariable Long id, @RequestBody Room room) {
        if (this.roomService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.roomService.put(id, room), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/room/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.roomService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.roomService.delete(id);

        return new ResponseEntity<>("Room deleted", HttpStatus.OK);
    }
}
