package pl.ug.virtualofficebackend.domain.user.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import javax.validation.Valid;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    // TODO: Add exception handling (https://www.baeldung.com/spring-mvc-custom-validator)

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(@Valid User user) {
        return this.userRepository.save(user);
    }

    public User get(long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User put(long id, @Valid User user) {
        user.setId(id);
        return this.userRepository.save(user);
    }

    public void delete(long id) {
        this.userRepository.deleteById(id);
    }
}
