package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "room", schema = "public", catalog = "postgres")
public class RoomEntity {
    private int roomId;
    private String name;
    private int capacity;

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (roomId != that.roomId) return false;
        if (capacity != that.capacity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + capacity;
        return result;
    }
}
