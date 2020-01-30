package pl.ug.virtualofficebackend.domain.office.boundary;

import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.List;

public interface OfficeService {

    // CREATE
    Office save(Office office);

    List<Office> save(List<Office> offices);

    // READ
    Office get(long id);

    List<Office> getAll();

    // UPDATE
    Office put(long id, Office office);

    // DELETE
    void delete(long id);

}
