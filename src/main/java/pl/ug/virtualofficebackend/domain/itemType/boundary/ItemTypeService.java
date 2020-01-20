package pl.ug.virtualofficebackend.domain.itemType.boundary;

import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;

import java.util.List;

public interface ItemTypeService {

    // CREATE
    ItemType save(ItemType itemType);

    // READ
    ItemType get(long id);

    List<ItemType> getAll();

    // UPDATE
    ItemType put(long id, ItemType decoration);

    // DELETE
    void delete(long id);

}
