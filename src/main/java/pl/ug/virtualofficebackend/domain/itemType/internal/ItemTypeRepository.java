package pl.ug.virtualofficebackend.domain.itemType.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
}
