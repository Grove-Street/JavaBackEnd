package pl.ug.virtualofficebackend.domain.decoration.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.decoration.boundary.DecorationService;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import javax.validation.Valid;
import java.util.List;

@Service
public class DecorationServiceImpl implements DecorationService {
    private DecorationRepository decorationRepository;

    @Autowired
    public DecorationServiceImpl(DecorationRepository decorationRepository) {
        this.decorationRepository = decorationRepository;
    }

    public Decoration save(@Valid Decoration decoration) {
        return this.decorationRepository.save(decoration);
    }

    public List<Decoration> save(@Valid List<Decoration> decorations) {
        return this.decorationRepository.saveAll(decorations);
    }

    public Decoration get(long id) {
        return this.decorationRepository.findById(id).orElse(null);
    }

    public List<Decoration> getAll() {
        return this.decorationRepository.findAll();
    }

    public Decoration put(long id, @Valid Decoration decoration) {
        decoration.setId(id);
        return this.decorationRepository.save(decoration);
    }

    public void delete(long id) {
        this.decorationRepository.deleteById(id);
    }

    public List<Decoration> getByOffice(Office office) {
        return this.decorationRepository.findAllByOffice(office);
    }
}
