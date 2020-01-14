package pl.ug.virtualofficebackend.domain.office.internal;

import org.springframework.data.repository.CrudRepository;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

public interface OfficeRepository extends CrudRepository<Office, Long> {
}
