package pl.ug.virtualofficebackend.domain.decoration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.common.Rotation;
import pl.ug.virtualofficebackend.domain.decorationType.entity.DecorationType;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "decoration")
public class Decoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    /*
        Starts at (x1, y1)
        Ends at (x2, y2)

        Every Decoration is displayed as rectangle
     */

    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Rotation is mandatory")
    private Rotation rotation;

    @ManyToOne
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
    //endregion
}
