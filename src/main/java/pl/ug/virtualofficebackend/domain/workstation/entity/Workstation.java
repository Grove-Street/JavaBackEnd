package pl.ug.virtualofficebackend.domain.workstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.common.model.Rotation;
import pl.ug.virtualofficebackend.common.validator.LocationCheck;
import pl.ug.virtualofficebackend.domain.item.entity.Item;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "workstation")
@LocationCheck(x1PositionFieldName = "x1Position", y1PositionFieldName = "y1Position",
        x2PositionFieldName = "x2Position", y2PositionFieldName = "y2Position",
        message = "Invalid location. ")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    /*
        Starts at (x1, y1)
        Ends at (x2, y2)

        Every Workstation is displayed as rectangle
     */

    //region Position
    private int x1Position;

    private int y1Position;

    private int x2Position;

    private int y2Position;
    //endregion


    @Enumerated(EnumType.STRING)
    private Rotation rotation;

    @JsonIgnore
    @OneToMany(mappedBy = "workstation")
    private List<Item> itemList;

    @OneToOne
    private User user;

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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
    //endregion

}
