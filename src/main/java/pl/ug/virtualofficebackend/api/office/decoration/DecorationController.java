package pl.ug.virtualofficebackend.api.office.decoration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.decoration.boundary.DecorationService;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;

import java.util.List;

@CrossOrigin
@RestController
public class DecorationController {
    private DecorationService decorationService;

    @Autowired
    public DecorationController(DecorationService decorationService) {
        this.decorationService = decorationService;
    }

    @PostMapping("/api/decoration")
    public ResponseEntity<Decoration> post(RequestEntity<Decoration> decoration) {
        if (decoration.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.decorationService.save(decoration.getBody()), HttpStatus.OK);
    }

    @GetMapping("/api/decoration")
    public ResponseEntity<List<Decoration>> get() {
        return new ResponseEntity<>(this.decorationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/decoration/{id}")
    public ResponseEntity<Decoration> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.decorationService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/decoration/{id}")
    public ResponseEntity<Decoration> put(@PathVariable String id, RequestEntity<Decoration> decoration) {
        if (decoration.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.decorationService.put(longId, decoration.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/decoration/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.decorationService.delete(longId);

            return new ResponseEntity<>("Decoration deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
