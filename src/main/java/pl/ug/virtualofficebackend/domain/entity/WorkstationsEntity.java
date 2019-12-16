package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workstations", schema = "public", catalog = "postgres")
public class WorkstationsEntity {
    private int workstationId;

    @Id
    @Column(name = "workstation_id")
    public int getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(int workstationId) {
        this.workstationId = workstationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkstationsEntity that = (WorkstationsEntity) o;

        if (workstationId != that.workstationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return workstationId;
    }
}
