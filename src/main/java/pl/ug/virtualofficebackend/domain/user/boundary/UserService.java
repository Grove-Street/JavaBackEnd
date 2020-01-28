package pl.ug.virtualofficebackend.domain.user.boundary;

import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import java.util.List;

public interface UserService {

    // CREATE
    User save(User user);

    List<User> save(List<User> users);

    // READ
    User get(long id);

    List<User> getAll();

    // UPDATE
    User put(long id, User user);

    // DELETE
    void delete(long id);

    List<User> getByOffice(Office office);

    User getByUsername(String username);

}
