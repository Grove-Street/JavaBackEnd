package pl.ug.virtualofficebackend.domain.office.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import javax.validation.Valid;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private OfficeRepository officeRepository;

    // TODO: Add exception handling (https://www.baeldung.com/spring-mvc-custom-validator)

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office save(@Valid Office office) {
        return this.officeRepository.save(office);
    }

    public Office get(long id) {
        return this.officeRepository.findById(id).orElse(null);
    }

    public List<Office> getAll() {
        return this.officeRepository.findAll();
    }

    public Office put(long id, @Valid Office office) {
        office.setId(id);
        return this.officeRepository.save(office);
    }

    public void delete(long id) {
        this.officeRepository.deleteById(id);
    }
}
