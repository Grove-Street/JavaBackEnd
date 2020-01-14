package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/api/workstation")
    public ResponseEntity<List<Workstation>> getWorkstation() {
        return new ResponseEntity<>(this.workstationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/workstation/{id}")
    public ResponseEntity<Workstation> getWorkstation(@PathVariable String id) {
        try {
            long parsedId = Long.parseLong(id);

            return new ResponseEntity<>(this.workstationService.get(parsedId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("api/workstation")
    public ResponseEntity<Workstation> postWorkstation(RequestEntity<Workstation> requestWorkstation) {
        Workstation workstation = requestWorkstation.getBody();

        if(workstation != null && this.workstationService.add(workstation)) {
            return new ResponseEntity<>(workstation, HttpStatus.OK);
        }

        return new ResponseEntity<>(workstation, HttpStatus.BAD_REQUEST);
    }


}
