package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/api/office")
    public ResponseEntity<List<Office>> getOffice() {
        return new ResponseEntity<>(this.officeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/office/{id}")
    public ResponseEntity<Office> getOffice(@PathVariable String id) {
        try {
            long parsedId = Long.parseLong(id);

            return new ResponseEntity<>(this.officeService.get(parsedId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
