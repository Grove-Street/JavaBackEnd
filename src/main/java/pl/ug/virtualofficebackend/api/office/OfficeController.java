package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.List;

@RestController
public class OfficeController {
    private OfficeService service;

    @Autowired
    public OfficeController(OfficeService service) {
        this.service = service;
    }

    @GetMapping("/api/office")
    public List<Office> getOffice() {
        return this.service.getAll();
    }

    @GetMapping("/api/office/{id}")
    public Office getOffice(@PathVariable String id) {
        try {
            long parsedId = Long.parseLong(id);

            return this.service.get(parsedId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
