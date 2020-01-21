package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.List;

@RestController
public class OfficeController {
    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @CrossOrigin
    @PostMapping("/api/office")
    public ResponseEntity<Office> post(@RequestBody Office office) {
        return new ResponseEntity<>(this.officeService.save(office), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/office")
    public ResponseEntity<List<Office>> get() {
        return new ResponseEntity<>(this.officeService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/office/{id}")
    public ResponseEntity<Office> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.officeService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/office/{id}")
    public ResponseEntity<Office> put(@PathVariable Long id, @RequestBody Office office) {
        if (this.officeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.officeService.put(id, office), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/office/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.officeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.officeService.delete(id);

        return new ResponseEntity<>("Office deleted", HttpStatus.OK);
    }
}
