package pl.ug.virtualofficebackend.domain.decorationType.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.decorationType.boundary.DecorationTypeService;
import pl.ug.virtualofficebackend.domain.decorationType.entity.DecorationType;

import javax.validation.Valid;
import java.util.List;

@Service
public class DecorationTypeServiceImpl implements DecorationTypeService {
    private DecorationTypeRepository decorationTypeRepository;

    // TODO: Add exception handling (https://www.baeldung.com/spring-mvc-custom-validator)

    @Autowired
    public DecorationTypeServiceImpl(DecorationTypeRepository decorationTypeRepository) {
        this.decorationTypeRepository = decorationTypeRepository;
    }

    public DecorationType save(@Valid DecorationType decorationType) {
        return this.decorationTypeRepository.save(decorationType);
    }

    public DecorationType get(long id) {
        return this.decorationTypeRepository.findById(id).orElse(null);
    }

    public List<DecorationType> getAll() {
        return this.decorationTypeRepository.findAll();
    }

    public DecorationType put(long id, @Valid DecorationType decoration) {
        decoration.setId(id);
        return this.decorationTypeRepository.save(decoration);
    }

    public void delete(long id) {
        this.decorationTypeRepository.deleteById(id);
    }
}
