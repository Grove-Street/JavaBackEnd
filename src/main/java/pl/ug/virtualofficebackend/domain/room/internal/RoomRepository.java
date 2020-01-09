package pl.ug.virtualofficebackend.domain.room.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.room.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
