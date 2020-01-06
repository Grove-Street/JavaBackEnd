package pl.ug.virtualofficebackend.domain.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
