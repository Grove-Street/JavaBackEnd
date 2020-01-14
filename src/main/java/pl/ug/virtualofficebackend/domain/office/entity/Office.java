package pl.ug.virtualofficebackend.domain.office.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;
import pl.ug.virtualofficebackend.domain.room.entity.Room;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "office")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    /*
        Ignore some fields because front isn't prepared
     */

    @JsonIgnore
    @OneToMany(mappedBy = "office")
    private List<Decoration> decorations;

    @JsonIgnore
    @OneToMany(mappedBy = "office")
    private List<Room> rooms;

    @OneToMany(mappedBy = "office", fetch = FetchType.EAGER)
    private List<Workstation> workstations;

    @JsonIgnore
    @OneToMany(mappedBy = "office")
    private List<User> users;

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

    public List<Decoration> getDecorations() {
        return decorations;
    }

    public void setDecorations(List<Decoration> decorations) {
        this.decorations = decorations;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Workstation> getWorkstations() {
        return workstations;
    }

    public void setWorkstations(List<Workstation> workstations) {
        this.workstations = workstations;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    //endregion
}
