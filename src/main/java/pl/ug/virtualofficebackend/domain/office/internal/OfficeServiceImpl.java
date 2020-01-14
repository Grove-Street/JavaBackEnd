package pl.ug.virtualofficebackend.domain.office.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.office.boundary.OfficeService;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private OfficeRepository repository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository repository) {
        this.repository = repository;
    }

    public Office get(long id) {
        return this.repository.findById(id).orElse(null);
    }

    public List<Office> getAll() {
        List<Office> offices = new ArrayList<>();

        this.repository.findAll().forEach(offices::add);

        return offices;
    }
}
