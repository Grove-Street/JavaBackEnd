package pl.ug.virtualofficebackend.api.office.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @PostMapping("/api/itemType")
    public ResponseEntity<ItemType> post(RequestEntity<ItemType> itemType) {
        if (itemType.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.itemTypeService.save(itemType.getBody()), HttpStatus.OK);
    }

    @GetMapping("/api/itemType")
    public ResponseEntity<List<ItemType>> get() {
        return new ResponseEntity<>(this.itemTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/itemType/{id}")
    public ResponseEntity<ItemType> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.itemTypeService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/itemType/{id}")
    public ResponseEntity<ItemType> put(@PathVariable String id, RequestEntity<ItemType> itemType) {
        if (itemType.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.itemTypeService.put(longId, itemType.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/itemType/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.itemTypeService.delete(longId);

            return new ResponseEntity<>("Item type deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
