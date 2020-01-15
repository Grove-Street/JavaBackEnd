package pl.ug.virtualofficebackend.domain.user.internal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserValidator userValidator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public boolean add(User user) {
        try {
           this.userRepository.save(user);
  
           return true;
        } catch (Exception e) {
           e.printStackTrace();
        }
  
        return false;
     }
  
     public User get(long id) {
        return this.userRepository.findById(id).orElse(null);
     }
  
     public List<User> getAll() {
        return new ArrayList<>(this.userRepository.findAll());
     }
}
