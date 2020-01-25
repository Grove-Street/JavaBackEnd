package pl.ug.virtualofficebackend.domain.decorationType.boundary;

import pl.ug.virtualofficebackend.domain.decorationType.entity.DecorationType;

import java.util.List;

public interface DecorationTypeService {

    // CREATE
    DecorationType save(DecorationType decorationType);

    List<DecorationType> save(List<DecorationType> decorationTypes);

    // READ
    DecorationType get(long id);

    List<DecorationType> getAll();

    // UPDATE
    DecorationType put(long id, DecorationType decorationType);

    // DELETE
    void delete(long id);

}
