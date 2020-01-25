package pl.ug.virtualofficebackend.api.office.decoration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.decorationType.boundary.DecorationTypeService;
import pl.ug.virtualofficebackend.domain.decorationType.entity.DecorationType;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/decorationType")
public class DecorationTypeController {
    private DecorationTypeService decorationTypeService;

    @Autowired
    public DecorationTypeController(DecorationTypeService decorationTypeService) {
        this.decorationTypeService = decorationTypeService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/son"}, produces = {"application/json"})
    public DecorationType post(@RequestBody DecorationType decorationType) {
        return this.decorationTypeService.save(decorationType);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<DecorationType> post(@RequestBody @Valid List<DecorationType> decorationTypes) {
        return this.decorationTypeService.save(decorationTypes);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<DecorationType> get() {
        return this.decorationTypeService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public DecorationType get(@PathVariable Long id) {
        return this.decorationTypeService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public DecorationType put(@PathVariable Long id, @RequestBody DecorationType decorationType) {
        return this.decorationTypeService.put(id, decorationType);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.decorationTypeService.delete(id);
    }
}
