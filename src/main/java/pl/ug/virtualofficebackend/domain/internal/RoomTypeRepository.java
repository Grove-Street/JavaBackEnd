package pl.ug.virtualofficebackend.domain.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.entity.RoomType;

@Repository
public interface RoomTypeRepository extends CrudRepository<RoomType, Long> {
}
