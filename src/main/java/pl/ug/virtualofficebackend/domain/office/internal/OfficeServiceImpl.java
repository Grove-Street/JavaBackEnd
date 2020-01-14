package pl.ug.virtualofficebackend.domain.office.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office get(long id) {
        return this.officeRepository.findById(id).orElse(null);
    }

    public List<Office> getAll() {
        return new ArrayList<>(this.officeRepository.findAll());
    }
}
