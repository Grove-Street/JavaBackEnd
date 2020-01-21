package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.workstation.boundary.WorkstationService;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import java.util.List;

@CrossOrigin
@RestController
public class WorkstationController {
    private WorkstationService workstationService;

    @Autowired
    public WorkstationController(WorkstationService workstationService) {
        this.workstationService = workstationService;
    }

    @PostMapping("/api/workstation")
    public ResponseEntity<Workstation> post(RequestEntity<Workstation> workstation) {
        if (workstation.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.workstationService.save(workstation.getBody()), HttpStatus.OK);
    }

    @GetMapping("/api/workstation")
    public ResponseEntity<List<Workstation>> get() {
        return new ResponseEntity<>(this.workstationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/workstation/{id}")
    public ResponseEntity<Workstation> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.workstationService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/workstation/{id}")
    public ResponseEntity<Workstation> put(@PathVariable String id, RequestEntity<Workstation> decoration) {
        if (decoration.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.workstationService.put(longId, decoration.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/workstation/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.workstationService.delete(longId);

            return new ResponseEntity<>("Workstation deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
