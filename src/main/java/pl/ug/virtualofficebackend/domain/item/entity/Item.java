package pl.ug.virtualofficebackend.domain.item.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.domain.itemType.entity.ItemType;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @ManyToOne
    @NotBlank(message = "Item type is mandatory")
    private ItemType type;

    @JsonIgnore
    @ManyToOne
    private Workstation workstation;

    @JsonIgnore
    @ManyToOne
    private Office office;

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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
    //endregion

}
