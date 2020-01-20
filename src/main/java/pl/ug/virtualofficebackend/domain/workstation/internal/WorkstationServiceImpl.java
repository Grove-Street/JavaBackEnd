package pl.ug.virtualofficebackend.domain.workstation.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.workstation.boundary.WorkstationService;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

import javax.validation.Valid;
import java.util.List;

@Service
public class WorkstationServiceImpl implements WorkstationService {
    private WorkstationRepository workstationRepository;

    // TODO: Add exception handling (https://www.baeldung.com/spring-mvc-custom-validator)

    @Autowired
    public WorkstationServiceImpl(WorkstationRepository workstationRepository) {
        this.workstationRepository = workstationRepository;
    }

    public Workstation save(@Valid Workstation workstation) {
        return this.workstationRepository.save(workstation);
    }

    public Workstation get(long id) {
        return this.workstationRepository.findById(id).orElse(null);
    }

    public List<Workstation> getAll() {
        return this.workstationRepository.findAll();
    }

    public Workstation put(long id, @Valid Workstation workstation) {
        workstation.setId(id);
        return this.workstationRepository.save(workstation);
    }

    public void delete(long id) {
        this.workstationRepository.deleteById(id);
    }
}
