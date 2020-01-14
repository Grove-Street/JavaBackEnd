package pl.ug.virtualofficebackend.domain.decorationType.entity;

import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "decoration_type")
public class DecorationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Decoration> decorationList;

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

    public List<Decoration> getDecorationList() {
        return decorationList;
    }

    public void setDecorationList(List<Decoration> decorationList) {
        this.decorationList = decorationList;
    }
    //endregion

}
