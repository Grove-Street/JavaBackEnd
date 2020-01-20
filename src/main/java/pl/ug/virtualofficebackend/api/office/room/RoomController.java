package pl.ug.virtualofficebackend.api.office.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @PostMapping("/api/room")
    public ResponseEntity<Room> post(RequestEntity<Room> room) {
        if (room.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.roomService.save(room.getBody()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/room")
    public ResponseEntity<List<Room>> get() {
        return new ResponseEntity<>(this.roomService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/room/{id}")
    public ResponseEntity<Room> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.roomService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/room/{id}")
    public ResponseEntity<Room> put(@PathVariable String id, RequestEntity<Room> room) {
        if (room.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.roomService.put(longId, room.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/room/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.roomService.delete(longId);

            return new ResponseEntity<>("Room deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
