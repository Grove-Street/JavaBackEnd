package pl.ug.virtualofficebackend.api.office.decoration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.decoration.boundary.DecorationService;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;

import java.util.List;

@RestController
public class DecorationController {
    private DecorationService decorationService;

    @Autowired
    public DecorationController(DecorationService decorationService) {
        this.decorationService = decorationService;
    }

    @CrossOrigin
    @PostMapping("/api/decoration")
    public ResponseEntity<Decoration> post(@RequestBody Decoration decoration) {
        return new ResponseEntity<>(this.decorationService.save(decoration), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/decoration")
    public ResponseEntity<List<Decoration>> get() {
        return new ResponseEntity<>(this.decorationService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/decoration/{id}")
    public ResponseEntity<Decoration> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.decorationService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/decoration/{id}")
    public ResponseEntity<Decoration> put(@PathVariable Long id, @RequestBody Decoration decoration) {
        if (this.decorationService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.decorationService.put(id, decoration), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/decoration/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.decorationService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.decorationService.delete(id);

        return new ResponseEntity<>("Decoration deleted", HttpStatus.OK);
    }
}
