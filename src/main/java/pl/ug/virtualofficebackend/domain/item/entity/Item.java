package pl.ug.virtualofficebackend.domain.item.entity;

import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import javax.persistence.*;

@Entity(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private ItemType type;

    @ManyToOne
    private Workstation workstation;

    //region GET SET
    public long getId() {
        return id;
    }

    public void setId(long itemId) {
        this.id = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Workstation getWorkstation() {
        return workstation;
    }

    public void setWorkstation(Workstation workstation) {
        this.workstation = workstation;
    }
    //endregion

}
