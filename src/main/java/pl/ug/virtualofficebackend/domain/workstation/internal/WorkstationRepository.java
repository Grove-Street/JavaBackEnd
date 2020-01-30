package pl.ug.virtualofficebackend.domain.workstation.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import java.util.List;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

    List<Workstation> findAllByOffice(Office office);

}
