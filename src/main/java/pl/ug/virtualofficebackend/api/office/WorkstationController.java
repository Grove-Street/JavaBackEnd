package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.workstation.boundary.WorkstationService;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import java.util.List;

@RestController
public class WorkstationController {
    private WorkstationService workstationService;

    @Autowired
    public WorkstationController(WorkstationService workstationService) {
        this.workstationService = workstationService;
    }

    @CrossOrigin
    @PostMapping("/api/workstation")
    public ResponseEntity<Workstation> post(@RequestBody Workstation workstation) {
        return new ResponseEntity<>(this.workstationService.save(workstation), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/workstation")
    public ResponseEntity<List<Workstation>> get() {
        return new ResponseEntity<>(this.workstationService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/workstation/{id}")
    public ResponseEntity<Workstation> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.workstationService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/workstation/{id}")
    public ResponseEntity<Workstation> put(@PathVariable Long id, @RequestBody Workstation workstation) {
        if (this.workstationService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.workstationService.put(id, workstation), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/workstation/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.workstationService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.workstationService.delete(id);

        return new ResponseEntity<>("Workstation deleted", HttpStatus.OK);
    }
}
