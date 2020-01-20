package pl.ug.virtualofficebackend.api.office.decoration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.decorationType.boundary.DecorationTypeService;
import pl.ug.virtualofficebackend.domain.decorationType.entity.DecorationType;

import java.util.List;

@RestController
public class DecorationTypeController {
    private DecorationTypeService decorationTypeService;

    @Autowired
    public DecorationTypeController(DecorationTypeService decorationTypeService) {
        this.decorationTypeService = decorationTypeService;
    }

    @PostMapping("/api/decorationType")
    public ResponseEntity<DecorationType> post(RequestEntity<DecorationType> decorationType) {
        if (decorationType.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.decorationTypeService.save(decorationType.getBody()), HttpStatus.OK);
    }

    @GetMapping("/api/decorationType")
    public ResponseEntity<List<DecorationType>> get() {
        return new ResponseEntity<>(this.decorationTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/decorationType/{id}")
    public ResponseEntity<DecorationType> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.decorationTypeService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/decorationType/{id}")
    public ResponseEntity<DecorationType> put(@PathVariable String id, RequestEntity<DecorationType> decorationType) {
        if (decorationType.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.decorationTypeService.put(longId, decorationType.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/decorationType/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.decorationTypeService.delete(longId);

            return new ResponseEntity<>("Decoration type deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
