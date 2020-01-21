package pl.ug.virtualofficebackend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/api/user")
    public ResponseEntity<User> post(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/user")
    public ResponseEntity<List<User>> get() {
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.get(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> put(@PathVariable Long id, @RequestBody User user) {
        if(this.userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.userService.put(id, user), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if(this.userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.userService.delete(id);

        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
