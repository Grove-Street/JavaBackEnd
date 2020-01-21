package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.List;

@CrossOrigin
@RestController
public class OfficeController {
    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/api/office")
    public ResponseEntity<Office> post(RequestEntity<Office> office) {
        if (office.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.officeService.save(office.getBody()), HttpStatus.OK);
    }

    @GetMapping("/api/office")
    public ResponseEntity<List<Office>> get() {
        return new ResponseEntity<>(this.officeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/office/{id}")
    public ResponseEntity<Office> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.officeService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/office/{id}")
    public ResponseEntity<Office> put(@PathVariable String id, RequestEntity<Office> office) {
        if (office.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.officeService.put(longId, office.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/office/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.officeService.delete(longId);

            return new ResponseEntity<>("Office deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
