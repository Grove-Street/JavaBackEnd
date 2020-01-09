package pl.ug.virtualofficebackend.domain.workstation.internal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

@Repository
public interface WorkstationRepository extends CrudRepository<Workstation, Long> {
}
