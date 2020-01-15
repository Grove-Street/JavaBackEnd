package pl.ug.virtualofficebackend.domain.item.boundary;

import java.util.List;

import pl.ug.virtualofficebackend.domain.item.entity.Item;

public interface ItemService {

    boolean add(Item user);

    Item get(long id);

    List<Item> getAll();

}