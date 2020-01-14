package pl.ug.virtualofficebackend.domain.office.boundary;

import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.List;

public interface OfficeService {

    Office get(long id);

    List<Office> getAll();

}
