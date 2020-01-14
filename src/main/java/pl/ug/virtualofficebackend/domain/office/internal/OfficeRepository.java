package pl.ug.virtualofficebackend.domain.office.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

@Repository
public interface OfficeRepository extends CrudRepository<Office, Long> {
}
