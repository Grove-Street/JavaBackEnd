package pl.ug.virtualofficebackend.domain.item.boundary;

import pl.ug.virtualofficebackend.domain.item.entity.Item;

import java.util.List;

public interface ItemService {

    // CREATE
    Item save(Item itemType);

    // READ
    Item get(long id);

    List<Item> getAll();

    // UPDATE
    Item put(long id, Item decoration);

    // DELETE
    void delete(long id);

}
