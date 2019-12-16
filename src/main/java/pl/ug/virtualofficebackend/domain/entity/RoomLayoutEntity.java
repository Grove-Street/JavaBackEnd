package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "room_layout", schema = "public", catalog = "postgres")
@IdClass(RoomLayoutEntityPK.class)
public class RoomLayoutEntity {
    private int roomId;
    private int workstationId;
    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;
    private String rotation;

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Id
    @Column(name = "workstation_id")
    public int getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(int workstationId) {
        this.workstationId = workstationId;
    }

    @Basic
    @Column(name = "x1_location")
    public int getX1Location() {
        return x1Location;
    }

    public void setX1Location(int x1Location) {
        this.x1Location = x1Location;
    }

    @Basic
    @Column(name = "y1_location")
    public int getY1Location() {
        return y1Location;
    }

    public void setY1Location(int y1Location) {
        this.y1Location = y1Location;
    }

    @Basic
    @Column(name = "x2_location")
    public int getX2Location() {
        return x2Location;
    }

    public void setX2Location(int x2Location) {
        this.x2Location = x2Location;
    }

    @Basic
    @Column(name = "y2_location")
    public int getY2Location() {
        return y2Location;
    }

    public void setY2Location(int y2Location) {
        this.y2Location = y2Location;
    }

    @Basic
    @Column(name = "rotation")
    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomLayoutEntity that = (RoomLayoutEntity) o;

        if (roomId != that.roomId) return false;
        if (workstationId != that.workstationId) return false;
        if (x1Location != that.x1Location) return false;
        if (y1Location != that.y1Location) return false;
        if (x2Location != that.x2Location) return false;
        if (y2Location != that.y2Location) return false;
        if (rotation != null ? !rotation.equals(that.rotation) : that.rotation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + workstationId;
        result = 31 * result + x1Location;
        result = 31 * result + y1Location;
        result = 31 * result + x2Location;
        result = 31 * result + y2Location;
        result = 31 * result + (rotation != null ? rotation.hashCode() : 0);
        return result;
    }
}
