package pl.ug.virtualofficebackend.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "office_user", schema = "public", catalog = "postgres")
public class OfficeUserEntity {
    private String userId;
    private String username;
    private String password;
    private Timestamp created;
    private Timestamp updated;
    private boolean deleted;
    private UserDetailsEntity userDetailsByUserId;
    private Collection<WorkstationsEntity> workstationsByUserId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Basic
    @Column(name = "deleted")
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficeUserEntity that = (OfficeUserEntity) o;

        if (deleted != that.deleted) return false;
        if (!Objects.equals(userId, that.userId)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(created, that.created)) return false;
        if (!Objects.equals(updated, that.updated)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (deleted ? 1 : 0);
        return result;
    }

    @OneToOne(mappedBy = "officeUserByUserId")
    public UserDetailsEntity getUserDetailsByUserId() {
        return userDetailsByUserId;
    }

    public void setUserDetailsByUserId(UserDetailsEntity userDetailsByUserId) {
        this.userDetailsByUserId = userDetailsByUserId;
    }

    @OneToMany(mappedBy = "officeUserByUserId")
    public Collection<WorkstationsEntity> getWorkstationsByUserId() {
        return workstationsByUserId;
    }

    public void setWorkstationsByUserId(Collection<WorkstationsEntity> workstationsByUserId) {
        this.workstationsByUserId = workstationsByUserId;
    }
}
