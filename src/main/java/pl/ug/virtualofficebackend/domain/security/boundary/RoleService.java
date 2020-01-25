package pl.ug.virtualofficebackend.domain.security.boundary;

import pl.ug.virtualofficebackend.domain.security.entity.Role;

import java.util.List;

public interface RoleService {

    // CREATE
    Role save(Role role);

    List<Role> save(List<Role> roles);

    // READ
    Role get(long id);

    List<Role> getAll();

    // UPDATE
    Role put(long id, Role user);

    // DELETE
    void delete(long id);

}