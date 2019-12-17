package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "workstations_composition", schema = "public", catalog = "postgres")
public class WorkstationsCompositionEntity {
    private int workstationId;
    private int itemId;
    private WorkstationsEntity workstationsByWorkstationId;
    private ItemEntity itemByItemId;

    @Id
    @Column(name = "workstation_id")
    public int getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(int workstationId) {
        this.workstationId = workstationId;
    }

    @Id
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkstationsCompositionEntity that = (WorkstationsCompositionEntity) o;

        if (workstationId != that.workstationId) return false;
        if (itemId != that.itemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workstationId;
        result = 31 * result + itemId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "workstation_id", referencedColumnName = "workstation_id", nullable = false)
    public WorkstationsEntity getWorkstationsByWorkstationId() {
        return workstationsByWorkstationId;
    }

    public void setWorkstationsByWorkstationId(WorkstationsEntity workstationsByWorkstationId) {
        this.workstationsByWorkstationId = workstationsByWorkstationId;
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id", nullable = false)
    public ItemEntity getItemByItemId() {
        return itemByItemId;
    }

    public void setItemByItemId(ItemEntity itemByItemId) {
        this.itemByItemId = itemByItemId;
    }
}
