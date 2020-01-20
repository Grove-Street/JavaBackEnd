package pl.ug.virtualofficebackend.domain.workstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.common.model.Rotation;
import pl.ug.virtualofficebackend.domain.item.entity.Item;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "workstation")
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

    // (x1,y1) i (x2,y2)
    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;

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
