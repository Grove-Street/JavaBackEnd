package pl.ug.virtualofficebackend.domain.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.entity.DecorationType;

@Repository
public interface DecorationTypeRepository extends CrudRepository<DecorationType, Long> {
}
