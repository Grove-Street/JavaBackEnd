package pl.ug.virtualofficebackend.domain.security.internal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.security.entity.VerificationToken;

@Repository
public interface TokenRepository extends CrudRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
