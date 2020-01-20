package pl.ug.virtualofficebackend.domain.user.boundary;

import java.util.List;

import pl.ug.virtualofficebackend.domain.user.entity.User;

public interface UserService {

    boolean add(User user);

    User get(long id);

    List<User> getAll();

}
