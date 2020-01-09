package pl.ug.virtualofficebackend.domain.roomType.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.roomType.entity.RoomType;

@Repository
public interface RoomTypeRepository extends CrudRepository<RoomType, Long> {
}
