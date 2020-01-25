package pl.ug.virtualofficebackend.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.common.validator.LocationCheck;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.roomType.entity.RoomType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "room")
@LocationCheck(x1PositionFieldName = "x1Position", y1PositionFieldName = "y1Position",
        x2PositionFieldName = "x2Position", y2PositionFieldName = "y2Position",
        message = "Invalid location. ")
public class Room {
    private long id;
    private String name;
    private int capacity;

    /*
        Starts at (x1, y1)
        Ends at (x2, y2)

        Every Room is displayed as rectangle
     */

    //region Position
    private int x1Position;
    private int y1Position;
    private int x2Position;
    private int y2Position;
    //endregion

    private RoomType type;
    private Office office;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotBlank(message = "Name is mandatory. ")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value = 1, message = "At least one person capacity is required. ")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getX1Position() {
        return x1Position;
    }

    public void setX1Position(int x1Position) {
        this.x1Position = x1Position;
    }

    public int getY1Position() {
        return y1Position;
    }

    public void setY1Position(int y1Position) {
        this.y1Position = y1Position;
    }

    public int getX2Position() {
        return x2Position;
    }

    public void setX2Position(int x2Position) {
        this.x2Position = x2Position;
    }

    public int getY2Position() {
        return y2Position;
    }

    public void setY2Position(int y2Position) {
        this.y2Position = y2Position;
    }

    @ManyToOne
    @NotNull(message = "Room type is mandatory. ")
    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    @JsonIgnore
    @ManyToOne
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
