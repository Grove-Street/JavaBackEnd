package pl.ug.virtualofficebackend.api.office.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.itemType.boundary.ItemTypeService;
import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/itemType")
public class ItemTypeController {
    private ItemTypeService itemTypeService;

    @Autowired
    public ItemTypeController(ItemTypeService itemTypeService) {
        this.itemTypeService = itemTypeService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public ItemType post(@RequestBody ItemType itemType) {
        return this.itemTypeService.save(itemType);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<ItemType> post(@RequestBody @Valid List<ItemType> itemTypes) {
        return this.itemTypeService.save(itemTypes);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<ItemType> get() {
        return this.itemTypeService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ItemType get(@PathVariable Long id) {
        return this.itemTypeService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public ItemType put(@PathVariable Long id, @RequestBody ItemType itemType) {
        return this.itemTypeService.put(id, itemType);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.itemTypeService.delete(id);
    }
}
