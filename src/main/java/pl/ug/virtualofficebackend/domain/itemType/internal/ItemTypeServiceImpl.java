package pl.ug.virtualofficebackend.domain.itemType.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.itemType.boundary.ItemTypeService;
import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;

import javax.validation.Valid;
import java.util.List;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {
    private ItemTypeRepository itemTypeRepository;

    @Autowired
    public ItemTypeServiceImpl(ItemTypeRepository itemTypeRepository) {
        this.itemTypeRepository = itemTypeRepository;
    }

    public ItemType save(@Valid ItemType itemType) {
        return this.itemTypeRepository.save(itemType);
    }

    public List<ItemType> save(@Valid List<ItemType> itemTypes) {
        return this.itemTypeRepository.saveAll(itemTypes);
    }

    public ItemType get(long id) {
        return this.itemTypeRepository.findById(id).orElse(null);
    }

    public List<ItemType> getAll() {
        return this.itemTypeRepository.findAll();
    }

    public ItemType put(long id, @Valid ItemType decoration) {
        decoration.setId(id);
        return this.itemTypeRepository.save(decoration);
    }

    public void delete(long id) {
        this.itemTypeRepository.deleteById(id);
    }
}
