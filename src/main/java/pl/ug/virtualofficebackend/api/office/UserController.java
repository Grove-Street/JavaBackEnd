package pl.ug.virtualofficebackend.api.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user")
    public ResponseEntity<User> post(RequestEntity<User> user) {
        if (user.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.userService.save(user.getBody()), HttpStatus.OK);
    }

    @GetMapping("/api/user")
    public ResponseEntity<List<User>> get() {
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.userService.get(longId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> put(@PathVariable String id, RequestEntity<User> user) {
        if (user.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            long longId = Long.parseLong(id);

            return new ResponseEntity<>(this.userService.put(longId, user.getBody()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            long longId = Long.parseLong(id);

            this.userService.delete(longId);

            return new ResponseEntity<>("User deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
