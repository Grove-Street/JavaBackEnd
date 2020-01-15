package pl.ug.virtualofficebackend.domain.room.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.ug.virtualofficebackend.domain.room.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
