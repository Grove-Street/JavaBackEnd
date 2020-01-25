package pl.ug.virtualofficebackend.domain.room.boundary;

import pl.ug.virtualofficebackend.domain.room.entity.Room;

import java.util.List;

public interface RoomService {

    // CREATE
    Room save(Room room);

    List<Room> save(List<Room> room);

    // READ
    Room get(long id);

    List<Room> getAll();

    // UPDATE
    Room put(long id, Room room);

    // DELETE
    void delete(long id);

}
