package pl.ug.virtualofficebackend.domain.workstation.boundary;

import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import java.util.List;

public interface WorkstationService {

    boolean add(Workstation workstation);

    Workstation get(long id);

    List<Workstation> getAll();

}
