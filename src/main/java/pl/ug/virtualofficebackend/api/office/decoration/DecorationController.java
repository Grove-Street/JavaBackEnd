package pl.ug.virtualofficebackend.api.office.decoration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.decoration.boundary.DecorationService;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/decoration")
public class DecorationController {
    private DecorationService decorationService;

    @Autowired
    public DecorationController(DecorationService decorationService) {
        this.decorationService = decorationService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/son"}, produces = {"application/json"})
    public Decoration post(@RequestBody Decoration decoration) {
        return this.decorationService.save(decoration);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<Decoration> post(@RequestBody @Valid List<Decoration> decorations) {
        return this.decorationService.save(decorations);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<Decoration> get() {
        return this.decorationService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Decoration get(@PathVariable Long id) {
        return this.decorationService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public Decoration put(@PathVariable Long id, @RequestBody Decoration decoration) {
        return this.decorationService.put(id, decoration);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.decorationService.delete(id);
    }
}
