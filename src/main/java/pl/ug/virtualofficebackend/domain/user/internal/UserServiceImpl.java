package pl.ug.virtualofficebackend.domain.user.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(@Valid User user) {
        return this.userRepository.save(user);
    }

    public List<User> save(@Valid List<User> users) {
        return this.userRepository.saveAll(users);
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

    public List<User> getByOffice(Office office) {
        return this.userRepository.findAllByOffice(office);
    }

}
