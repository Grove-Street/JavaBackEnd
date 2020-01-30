package pl.ug.virtualofficebackend.domain.decoration.boundary;

import pl.ug.virtualofficebackend.domain.decoration.entity.Decoration;
import pl.ug.virtualofficebackend.domain.office.entity.Office;

import java.util.List;

public interface DecorationService {

    // CREATE
    Decoration save(Decoration decoration);

    List<Decoration> save(List<Decoration> decorations);

    // READ
    Decoration get(long id);

    List<Decoration> getAll();

    // UPDATE
    Decoration put(long id, Decoration decoration);

    // DELETE
    void delete(long id);

    List<Decoration> getByOffice(Office office);

}
