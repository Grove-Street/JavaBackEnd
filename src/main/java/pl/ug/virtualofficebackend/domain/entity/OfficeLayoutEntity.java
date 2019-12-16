package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "office_layout", schema = "public", catalog = "postgres")
@IdClass(OfficeLayoutEntityPK.class)
public class OfficeLayoutEntity {
    private int officeId;
    private int roomId;
    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;

    @Id
    @Column(name = "office_id")
    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficeLayoutEntity that = (OfficeLayoutEntity) o;

        if (officeId != that.officeId) return false;
        if (roomId != that.roomId) return false;
        if (x1Location != that.x1Location) return false;
        if (y1Location != that.y1Location) return false;
        if (x2Location != that.x2Location) return false;
        if (y2Location != that.y2Location) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = officeId;
        result = 31 * result + roomId;
        result = 31 * result + x1Location;
        result = 31 * result + y1Location;
        result = 31 * result + x2Location;
        result = 31 * result + y2Location;
        return result;
    }
}
