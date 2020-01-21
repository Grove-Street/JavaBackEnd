package pl.ug.virtualofficebackend.domain.user.boundary;

import java.util.List;

import pl.ug.virtualofficebackend.domain.user.entity.User;

public interface UserService {

    // CREATE
    User save(User workstation);

    // READ
    User get(long id);

    List<User> getAll();

    // UPDATE
    User put(long id, User workstation);

    // DELETE
    void delete(long id);

}
