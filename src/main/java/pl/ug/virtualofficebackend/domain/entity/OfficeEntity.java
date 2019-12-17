package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "office", schema = "public", catalog = "postgres")
public class OfficeEntity {
    private int officeId;
    private String name;
    private String country;
    private String city;
    private String region;
    private String postalCode;
    private String address;
    private Collection<DecorationLayoutEntity> decorationLayoutsByOfficeId;
    private Collection<OfficeLayoutEntity> officeLayoutsByOfficeId;

    @Id
    @Column(name = "office_id")
    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
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
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficeEntity that = (OfficeEntity) o;

        if (officeId != that.officeId) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(country, that.country)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(region, that.region)) return false;
        if (!Objects.equals(postalCode, that.postalCode)) return false;
        if (!Objects.equals(address, that.address)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = officeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "officeByOfficeId")
    public Collection<DecorationLayoutEntity> getDecorationLayoutsByOfficeId() {
        return decorationLayoutsByOfficeId;
    }

    public void setDecorationLayoutsByOfficeId(Collection<DecorationLayoutEntity> decorationLayoutsByOfficeId) {
        this.decorationLayoutsByOfficeId = decorationLayoutsByOfficeId;
    }

    @OneToMany(mappedBy = "officeByOfficeId")
    public Collection<OfficeLayoutEntity> getOfficeLayoutsByOfficeId() {
        return officeLayoutsByOfficeId;
    }

    public void setOfficeLayoutsByOfficeId(Collection<OfficeLayoutEntity> officeLayoutsByOfficeId) {
        this.officeLayoutsByOfficeId = officeLayoutsByOfficeId;
    }
}
