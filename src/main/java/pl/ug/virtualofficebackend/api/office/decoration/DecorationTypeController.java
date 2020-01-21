package pl.ug.virtualofficebackend.api.office.decoration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @CrossOrigin
    @PostMapping("/api/decorationType")
    public ResponseEntity<DecorationType> post(@RequestBody DecorationType decorationType) {
        return new ResponseEntity<>(this.decorationTypeService.save(decorationType), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/decorationType")
    public ResponseEntity<List<DecorationType>> get() {
        return new ResponseEntity<>(this.decorationTypeService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/decorationType/{id}")
    public ResponseEntity<DecorationType> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.decorationTypeService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/decorationType/{id}")
    public ResponseEntity<DecorationType> put(@PathVariable Long id, @RequestBody DecorationType decorationType) {
        if (this.decorationTypeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.decorationTypeService.put(id, decorationType), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/decorationType/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.decorationTypeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.decorationTypeService.delete(id);

        return new ResponseEntity<>("Decoration type deleted", HttpStatus.OK);
    }
}
