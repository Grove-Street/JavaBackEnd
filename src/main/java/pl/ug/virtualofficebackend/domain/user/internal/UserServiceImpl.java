package pl.ug.virtualofficebackend.domain.user.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(@Valid User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public List<User> save(@Valid List<User> users) {
        for(User user : users) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        // XD

        return this.userRepository.saveAll(users);
    }

    public User get(long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User put(long id, @Valid User user) {
        User toUpdate = this.userRepository.findById(id).orElse(null);

        if(toUpdate == null) {
            return null;
        }

        if(user.getPassword() == null) {
            user.setPassword(toUpdate.getPassword());
        }

        user.setId(id);
        return this.userRepository.save(user);
    }

    public void delete(long id) {
        this.userRepository.deleteById(id);
    }

    public List<User> getByOffice(Office office) {
        return this.userRepository.findAllByOffice(office);
    }

    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

}
