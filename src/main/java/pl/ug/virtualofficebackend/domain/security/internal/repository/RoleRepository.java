package pl.ug.virtualofficebackend.domain.security.internal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.security.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
