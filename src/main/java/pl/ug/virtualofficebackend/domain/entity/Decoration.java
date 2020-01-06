package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;

@Entity(name = "decoration")
public class Decoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    /*
        Na ten moment start i koniec przedmiotu
        wszystko bedzie traktowane jako kwadrat

        np. doniczka zaczyna sie w (0,0) i konczy w (1,1)

        North/South/West/East
     */

    // (x1,y1) i (x2,y2)
    private int x1Location;
    private int y1Location;
    private int x2Location;
    private int y2Location;

    private String rotation;

    @ManyToOne
    private DecorationType type;

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

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }
    //endregion

}
