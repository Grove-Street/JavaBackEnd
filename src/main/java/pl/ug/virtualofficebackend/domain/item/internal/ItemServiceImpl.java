package pl.ug.virtualofficebackend.domain.item.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.item.boundary.ItemService;
import pl.ug.virtualofficebackend.domain.item.entity.Item;

import javax.validation.Valid;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item save(@Valid Item itemType) {
        return this.itemRepository.save(itemType);
    }

    public List<Item> save(@Valid List<Item> itemTypes) {
        return this.itemRepository.saveAll(itemTypes);
    }

    public Item get(long id) {
        return this.itemRepository.findById(id).orElse(null);
    }

    public List<Item> getAll() {
        return this.itemRepository.findAll();
    }

    public Item put(long id, @Valid Item decoration) {
        decoration.setId(id);
        return this.itemRepository.save(decoration);
    }

    public void delete(long id) {
        this.itemRepository.deleteById(id);
    }
}
