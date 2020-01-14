package pl.ug.virtualofficebackend.domain.itemType.entity;

import pl.ug.virtualofficebackend.domain.item.entity.Item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "item_type")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Item> itemList;

    //region GET SET
    public long getId() {
        return id;
    }

    public void setId(long typeId) {
        this.id = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    //endregion

}
