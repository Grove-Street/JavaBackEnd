package pl.ug.virtualofficebackend.domain.user.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
