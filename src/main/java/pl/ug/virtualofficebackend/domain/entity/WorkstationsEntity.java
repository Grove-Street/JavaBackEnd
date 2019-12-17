package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "workstations", schema = "public", catalog = "postgres")
public class WorkstationsEntity {
    private int workstationId;
    private String userId;
    private Collection<RoomLayoutEntity> roomLayoutsByWorkstationId;
    private OfficeUserEntity officeUserByUserId;
    private Collection<WorkstationsCompositionEntity> workstationsCompositionsByWorkstationId;

    @Id
    @Column(name = "workstation_id")
    public int getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(int workstationId) {
        this.workstationId = workstationId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkstationsEntity that = (WorkstationsEntity) o;

        if (workstationId != that.workstationId) return false;
        if (!Objects.equals(userId, that.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workstationId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "workstationsByWorkstationId")
    public Collection<RoomLayoutEntity> getRoomLayoutsByWorkstationId() {
        return roomLayoutsByWorkstationId;
    }

    public void setRoomLayoutsByWorkstationId(Collection<RoomLayoutEntity> roomLayoutsByWorkstationId) {
        this.roomLayoutsByWorkstationId = roomLayoutsByWorkstationId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public OfficeUserEntity getOfficeUserByUserId() {
        return officeUserByUserId;
    }

    public void setOfficeUserByUserId(OfficeUserEntity officeUserByUserId) {
        this.officeUserByUserId = officeUserByUserId;
    }

    @OneToMany(mappedBy = "workstationsByWorkstationId")
    public Collection<WorkstationsCompositionEntity> getWorkstationsCompositionsByWorkstationId() {
        return workstationsCompositionsByWorkstationId;
    }

    public void setWorkstationsCompositionsByWorkstationId(Collection<WorkstationsCompositionEntity> workstationsCompositionsByWorkstationId) {
        this.workstationsCompositionsByWorkstationId = workstationsCompositionsByWorkstationId;
    }
}
