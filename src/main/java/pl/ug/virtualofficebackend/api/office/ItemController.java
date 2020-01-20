package pl.ug.virtualofficebackend.api.office;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.ug.virtualofficebackend.domain.item.boundary.ItemService;
import pl.ug.virtualofficebackend.domain.item.entity.Item;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/item")
    public ResponseEntity<List<Item>> getOffice() {
        return new ResponseEntity<>(this.itemService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/item/{id}")
    public ResponseEntity<Item> getOffice(@PathVariable String id) {
        try {
            long parsedId = Long.parseLong(id);

            return new ResponseEntity<>(this.itemService.get(parsedId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("api/item")
    public ResponseEntity<Item> postWorkstation(RequestEntity<Item> requestItem) {
        Item item = requestItem.getBody();

        if(item != null && this.itemService.add(item)) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }

        return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
    }

}