package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "room_type", schema = "public", catalog = "postgres")
public class RoomTypeEntity {
    private int typeId;
    private String name;

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
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
