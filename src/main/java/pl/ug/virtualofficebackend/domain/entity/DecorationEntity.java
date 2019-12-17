package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "decoration", schema = "public", catalog = "postgres")
public class DecorationEntity {
    private int decorationId;
    private int typeId;
    private String name;
    private double width;
    private double length;
    private double height;
    private DecorationTypeEntity decorationTypeByTypeId;
    private DecorationLayoutEntity decorationLayoutByDecorationId;

    @Id
    @Column(name = "decoration_id")
    public int getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(int decorationId) {
        this.decorationId = decorationId;
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

        DecorationEntity that = (DecorationEntity) o;

        if (decorationId != that.decorationId) return false;
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
        result = decorationId;
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
    public DecorationTypeEntity getDecorationTypeByTypeId() {
        return decorationTypeByTypeId;
    }

    public void setDecorationTypeByTypeId(DecorationTypeEntity decorationTypeByTypeId) {
        this.decorationTypeByTypeId = decorationTypeByTypeId;
    }

    @OneToOne(mappedBy = "decorationByDecorationId")
    public DecorationLayoutEntity getDecorationLayoutByDecorationId() {
        return decorationLayoutByDecorationId;
    }

    public void setDecorationLayoutByDecorationId(DecorationLayoutEntity decorationLayoutByDecorationId) {
        this.decorationLayoutByDecorationId = decorationLayoutByDecorationId;
    }
}
