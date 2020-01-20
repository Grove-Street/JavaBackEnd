package pl.ug.virtualofficebackend.api.office.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @PostMapping("/api/roomType")
    public ResponseEntity<RoomType> post(RequestEntity<RoomType> roomType) {
        if (roomType.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.roomTypeService.save(roomType.getBody()), HttpStatus.OK);
    }

    @GetMapping("/api/roomType")
    public ResponseEntity<List<RoomType>> get() {
        return new ResponseEntity<>(this.roomTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/roomType/{id}")
    public ResponseEntity<RoomType> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.roomTypeService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/roomType/{id}")
    public ResponseEntity<RoomType> put(@PathVariable String id, RequestEntity<RoomType> roomType) {
        if (roomType.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.roomTypeService.put(longId, roomType.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/roomType/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.roomTypeService.delete(longId);

            return new ResponseEntity<>("Room type deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
