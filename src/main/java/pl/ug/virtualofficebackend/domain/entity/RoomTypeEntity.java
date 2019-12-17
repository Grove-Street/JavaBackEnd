package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "room_type", schema = "public", catalog = "postgres")
public class RoomTypeEntity {
    private int typeId;
    private String name;
    private Collection<RoomEntity> roomsByTypeId;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomTypeEntity that = (RoomTypeEntity) o;

        if (typeId != that.typeId) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roomTypeByTypeId")
    public Collection<RoomEntity> getRoomsByTypeId() {
        return roomsByTypeId;
    }

    public void setRoomsByTypeId(Collection<RoomEntity> roomsByTypeId) {
        this.roomsByTypeId = roomsByTypeId;
    }
}
