package pl.ug.virtualofficebackend.domain.itemType.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;

@Repository
public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {
}
