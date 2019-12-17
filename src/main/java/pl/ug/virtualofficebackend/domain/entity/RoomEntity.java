package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "public", catalog = "postgres")
public class RoomEntity {
    private int roomId;
    private int typeId;
    private String name;
    private int capacity;
    private Collection<OfficeLayoutEntity> officeLayoutsByRoomId;
    private RoomTypeEntity roomTypeByTypeId;
    private Collection<RoomLayoutEntity> roomLayoutsByRoomId;

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "type_id")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
        if (typeId != that.typeId) return false;
        if (capacity != that.capacity) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + typeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + capacity;
        return result;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<OfficeLayoutEntity> getOfficeLayoutsByRoomId() {
        return officeLayoutsByRoomId;
    }

    public void setOfficeLayoutsByRoomId(Collection<OfficeLayoutEntity> officeLayoutsByRoomId) {
        this.officeLayoutsByRoomId = officeLayoutsByRoomId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    public RoomTypeEntity getRoomTypeByTypeId() {
        return roomTypeByTypeId;
    }

    public void setRoomTypeByTypeId(RoomTypeEntity roomTypeByTypeId) {
        this.roomTypeByTypeId = roomTypeByTypeId;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<RoomLayoutEntity> getRoomLayoutsByRoomId() {
        return roomLayoutsByRoomId;
    }

    public void setRoomLayoutsByRoomId(Collection<RoomLayoutEntity> roomLayoutsByRoomId) {
        this.roomLayoutsByRoomId = roomLayoutsByRoomId;
    }
}
