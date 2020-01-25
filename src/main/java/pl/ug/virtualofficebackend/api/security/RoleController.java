package pl.ug.virtualofficebackend.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.ug.virtualofficebackend.domain.security.boundary.RoleService;
import pl.ug.virtualofficebackend.domain.security.entity.Role;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public Role post(@RequestBody @Valid Role role) {
        return this.roleService.save(role);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public List<Role> post(@RequestBody @Valid List<Role> roles) {
        return this.roleService.save(roles);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public List<Role> get() {
        return this.roleService.getAll();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Role get(@PathVariable Long id) {
        return this.roleService.get(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            consumes = {"application/json"}, produces = {"application/json"})
    public Role put(@PathVariable Long id, @RequestBody @Valid Role role) {
        return this.roleService.put(id, role);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public void delete(@PathVariable Long id) {
        this.roleService.delete(id);
    }
}
