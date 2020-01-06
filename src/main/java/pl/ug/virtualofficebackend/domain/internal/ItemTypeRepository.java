package pl.ug.virtualofficebackend.domain.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.entity.ItemType;

@Repository
public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {
}
