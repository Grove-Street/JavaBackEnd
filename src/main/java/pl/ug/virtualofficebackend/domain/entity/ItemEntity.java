package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "item", schema = "public", catalog = "postgres")
public class ItemEntity {
    private int itemId;
    private int typeId;
    private String name;
    private double width;
    private double length;
    private double height;
    private ItemTypeEntity itemTypeByTypeId;
    private Collection<WorkstationsCompositionEntity> workstationsCompositionsByItemId;

    @Id
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "type_id")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "width")
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Basic
    @Column(name = "length")
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Basic
    @Column(name = "height")
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        if (itemId != that.itemId) return false;
        if (typeId != that.typeId) return false;
        if (Double.compare(that.width, width) != 0) return false;
        if (Double.compare(that.length, length) != 0) return false;
        if (Double.compare(that.height, height) != 0) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemId;
        result = 31 * result + typeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    public ItemTypeEntity getItemTypeByTypeId() {
        return itemTypeByTypeId;
    }

    public void setItemTypeByTypeId(ItemTypeEntity itemTypeByTypeId) {
        this.itemTypeByTypeId = itemTypeByTypeId;
    }

    @OneToMany(mappedBy = "itemByItemId")
    public Collection<WorkstationsCompositionEntity> getWorkstationsCompositionsByItemId() {
        return workstationsCompositionsByItemId;
    }

    public void setWorkstationsCompositionsByItemId(Collection<WorkstationsCompositionEntity> workstationsCompositionsByItemId) {
        this.workstationsCompositionsByItemId = workstationsCompositionsByItemId;
    }
}
