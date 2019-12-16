package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RoomLayoutEntityPK implements Serializable {
    private int roomId;
    private int workstationId;

    @Column(name = "room_id")
    @Id
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Column(name = "workstation_id")
    @Id
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

        RoomLayoutEntityPK that = (RoomLayoutEntityPK) o;

        if (roomId != that.roomId) return false;
        if (workstationId != that.workstationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + workstationId;
        return result;
    }
}
