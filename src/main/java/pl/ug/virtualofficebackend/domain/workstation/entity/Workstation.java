package pl.ug.virtualofficebackend.domain.workstation.entity;

import pl.ug.virtualofficebackend.domain.item.entity.Item;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "workstation")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    /*
        Workstation sklada sie z kilku itemow
        np. biurko, komputer, fotel - mozna dopisal validator

        Na ten moment start i koniec przedmiotu
        wszystko bedzie traktowane jako kwadrat

        np. biurko zaczyna sie w (0,0) i konczy w (1,1)

        North/South/West/East
     */

    // (x1,y1) i (x2,y2)
    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;

    private String rotation;

    @OneToMany(mappedBy = "workstation")
    private List<Item> itemList;

    @OneToOne
    private User user;

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

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
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
    //endregion

}
