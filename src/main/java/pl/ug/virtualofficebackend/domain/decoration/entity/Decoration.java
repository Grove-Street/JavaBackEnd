package pl.ug.virtualofficebackend.domain.decoration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.ug.virtualofficebackend.common.model.Rotation;
import pl.ug.virtualofficebackend.domain.decorationType.entity.DecorationType;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "decoration")
public class Decoration {
    private long id;
    private String name;

    /*
        Placed at (x1, y1)
     */

    //region Position
    private int x1Position;
    private int y1Position;

    private Rotation rotation = Rotation.NORTH;
    //endregion

    private DecorationType type;
    private Office office;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long decorationId) {
        this.id = decorationId;
    }

    @NotBlank(message = "Name is mandatory")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @NotNull(message = "Decoration type is mandatory")
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

    @Enumerated(EnumType.STRING)
    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    @ManyToOne
    @JsonIgnore
    @JsonProperty(value = "office")
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

}
