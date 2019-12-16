package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "decoration_layout", schema = "public", catalog = "postgres")
public class DecorationLayoutEntity {
    private int decorationId;
    private int officeId;
    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;
    private String rotation;

    @Id
    @Column(name = "decoration_id")
    public int getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(int decorationId) {
        this.decorationId = decorationId;
    }

    @Basic
    @Column(name = "office_id")
    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
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

        DecorationLayoutEntity that = (DecorationLayoutEntity) o;

        if (decorationId != that.decorationId) return false;
        if (officeId != that.officeId) return false;
        if (x1Location != that.x1Location) return false;
        if (y1Location != that.y1Location) return false;
        if (x2Location != that.x2Location) return false;
        if (y2Location != that.y2Location) return false;
        if (rotation != null ? !rotation.equals(that.rotation) : that.rotation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = decorationId;
        result = 31 * result + officeId;
        result = 31 * result + x1Location;
        result = 31 * result + y1Location;
        result = 31 * result + x2Location;
        result = 31 * result + y2Location;
        result = 31 * result + (rotation != null ? rotation.hashCode() : 0);
        return result;
    }
}
