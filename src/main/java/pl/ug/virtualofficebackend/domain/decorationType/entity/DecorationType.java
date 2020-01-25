package pl.ug.virtualofficebackend.domain.decorationType.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "decoration_type")
public class DecorationType {
    private long id;
    private String name;

    private List<Decoration> decorationList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long typeId) {
        this.id = typeId;
    }

    @NotBlank(message = "Name is mandatory")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    public List<Decoration> getDecorationList() {
        return decorationList;
    }

    public void setDecorationList(List<Decoration> decorationList) {
        this.decorationList = decorationList;
    }

}
