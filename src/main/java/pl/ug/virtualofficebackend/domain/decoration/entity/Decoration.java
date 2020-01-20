package pl.ug.virtualofficebackend.domain.decoration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.common.model.Rotation;
import pl.ug.virtualofficebackend.common.validator.LocationCheck;
import pl.ug.virtualofficebackend.domain.decorationType.entity.DecorationType;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "decoration")
@LocationCheck(x1PositionFieldName = "x1Position", y1PositionFieldName = "y1Position",
        x2PositionFieldName = "x2Position", y2PositionFieldName = "y2Position",
        message = "Invalid location. ")
public class Decoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    /*
        Starts at (x1, y1)
        Ends at (x2, y2)

        Every Decoration is displayed as square.
     */

    //region Position
    private int x1Position;

    private int y1Position;

    private int x2Position;

    private int y2Position;
    //endregion

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Rotation is mandatory")
    private Rotation rotation;

    @ManyToOne
    @NotNull(message = "Decoration type is mandatory")
    private DecorationType type;

    @JsonIgnore
    @ManyToOne
    private Office office;

    //region GET SET
    public long getId() {
        return id;
    }

    public void setId(long decorationId) {
        this.id = decorationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DecorationType getType() {
        return type;
    }

    public void setType(DecorationType decorationType) {
        this.type = decorationType;
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

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
    //endregion
}
