package pl.ug.virtualofficebackend.api.office.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.item.boundary.ItemService;
import pl.ug.virtualofficebackend.domain.item.entity.Item;

import java.util.List;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @PostMapping("/api/item")
    public ResponseEntity<Item> post(@RequestBody Item item) {
        return new ResponseEntity<>(this.itemService.save(item), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/item")
    public ResponseEntity<List<Item>> get() {
        return new ResponseEntity<>(this.itemService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/item/{id}")
    public ResponseEntity<Item> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.itemService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/item/{id}")
    public ResponseEntity<Item> put(@PathVariable Long id, @RequestBody Item item) {
        if (this.itemService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.itemService.put(id, item), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/item/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.itemService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.itemService.delete(id);

        return new ResponseEntity<>("Item deleted", HttpStatus.OK);
    }
}
