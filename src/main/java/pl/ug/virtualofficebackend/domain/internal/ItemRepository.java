package pl.ug.virtualofficebackend.domain.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
