package pl.ug.virtualofficebackend.domain.workstation.boundary;

import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import java.util.List;

public interface WorkstationService {

    // CREATE
    Workstation save(Workstation workstation);

    List<Workstation> save(List<Workstation> workstations);

    // READ
    Workstation get(long id);

    List<Workstation> getAll();

    // UPDATE
    Workstation put(long id, Workstation workstation);

    // DELETE
    void delete(long id);

    List<Workstation> getByOffice(Office office);

}
