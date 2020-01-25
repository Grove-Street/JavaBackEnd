package pl.ug.virtualofficebackend.domain.security.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.security.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
