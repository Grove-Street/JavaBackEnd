package pl.ug.virtualofficebackend.domain.roomType.entity;

import pl.ug.virtualofficebackend.domain.room.entity.Room;

import javax.persistence.*;
import java.util.List;

@Entity(name = "room_type")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "type")
    private List<Room> roomList;

    //region GET SET
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
    //endregion

}
