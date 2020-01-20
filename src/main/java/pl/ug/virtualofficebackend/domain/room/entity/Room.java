package pl.ug.virtualofficebackend.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.common.model.Rotation;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.roomType.entity.RoomType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private int capacity;

    /*
        Starts at (x1, y1)
        Ends at (x2, y2)

        Every Room is displayed as rectangle
     */

    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Rotation is mandatory")
    private Rotation rotation;

    @ManyToOne
    private RoomType type;

    @JsonIgnore
    @ManyToOne
    private Office office;

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getX1Location() {
        return x1Location;
    }

    public void setX1Location(int x1Location) {
        this.x1Location = x1Location;
    }

    public int getY1Location() {
        return y1Location;
    }

    public void setY1Location(int y1Location) {
        this.y1Location = y1Location;
    }

    public int getX2Location() {
        return x2Location;
    }

    public void setX2Location(int x2Location) {
        this.x2Location = x2Location;
    }

    public int getY2Location() {
        return y2Location;
    }

    public void setY2Location(int y2Location) {
        this.y2Location = y2Location;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
    //endregion

}
