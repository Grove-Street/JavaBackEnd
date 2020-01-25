package pl.ug.virtualofficebackend.domain.roomType.boundary;


import pl.ug.virtualofficebackend.domain.roomType.entity.RoomType;

import java.util.List;

public interface RoomTypeService {

    // CREATE
    RoomType save(RoomType roomType);

    List<RoomType> save(List<RoomType> roomTypes);

    // READ
    RoomType get(long id);

    List<RoomType> getAll();

    // UPDATE
    RoomType put(long id, RoomType roomType);

    // DELETE
    void delete(long id);

}
