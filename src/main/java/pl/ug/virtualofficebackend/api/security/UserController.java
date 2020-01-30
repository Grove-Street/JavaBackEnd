package pl.ug.virtualofficebackend.api.security;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.ug.virtualofficebackend.domain.user.boundary.UserService;
import pl.ug.virtualofficebackend.domain.user.entity.User;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public User post(@RequestBody @Valid User user) {
        return this.userService.save(user);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<User> post(@RequestBody @Valid List<User> users) {
        return this.userService.save(users);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<User> get() {
        return this.userService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public User get(@PathVariable Long id) {
        return this.userService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET, produces = {"application/json"})
    public User getByUsername(@PathVariable String username) {
        return this.userService.getByUsername(username);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public User put(@PathVariable Long id, @RequestBody @Valid User user) {
        return this.userService.put(id, user);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.userService.delete(id);
    }
}
