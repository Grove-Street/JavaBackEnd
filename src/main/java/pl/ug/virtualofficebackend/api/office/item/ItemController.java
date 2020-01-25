package pl.ug.virtualofficebackend.api.office.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.item.boundary.ItemService;
import pl.ug.virtualofficebackend.domain.item.entity.Item;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/item")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/son"}, produces = {"application/json"})
    public Item post(@RequestBody Item item) {
        return this.itemService.save(item);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<Item> post(@RequestBody @Valid List<Item> items) {
        return this.itemService.save(items);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<Item> get() {
        return this.itemService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Item get(@PathVariable Long id) {
        return this.itemService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public Item put(@PathVariable Long id, @RequestBody Item item) {
        return this.itemService.put(id, item);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.itemService.delete(id);
    }
}
