package pl.ug.virtualofficebackend.api.office.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.itemType.boundary.ItemTypeService;
import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;

import java.util.List;

@RestController
public class ItemTypeController {
    private ItemTypeService itemTypeService;

    @Autowired
    public ItemTypeController(ItemTypeService itemTypeService) {
        this.itemTypeService = itemTypeService;
    }

    @CrossOrigin
    @PostMapping("/api/itemType")
    public ResponseEntity<ItemType> post(@RequestBody ItemType itemType) {
        return new ResponseEntity<>(this.itemTypeService.save(itemType), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/itemType")
    public ResponseEntity<List<ItemType>> get() {
        return new ResponseEntity<>(this.itemTypeService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/itemType/{id}")
    public ResponseEntity<ItemType> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.itemTypeService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/itemType/{id}")
    public ResponseEntity<ItemType> put(@PathVariable Long id, @RequestBody ItemType itemType) {
        if (this.itemTypeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.itemTypeService.put(id, itemType), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/itemType/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (this.itemTypeService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.itemTypeService.delete(id);

        return new ResponseEntity<>("Item type deleted", HttpStatus.OK);
    }
}
