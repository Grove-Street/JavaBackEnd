package pl.ug.virtualofficebackend.domain.decoration.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.decoration.boundary.DecorationService;
import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;

import javax.validation.Valid;
import java.util.List;

@Service
public class DecorationServiceImpl implements DecorationService {
    private DecorationRepository decorationRepository;

    // TODO: Add exception handling (https://www.baeldung.com/spring-mvc-custom-validator)

    @Autowired
    public DecorationServiceImpl(DecorationRepository decorationRepository) {
        this.decorationRepository = decorationRepository;
    }

    public Decoration save(@Valid Decoration decoration) {
        return this.decorationRepository.save(decoration);
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
}
