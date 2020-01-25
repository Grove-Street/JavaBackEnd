package pl.ug.virtualofficebackend.domain.security.internal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ug.virtualofficebackend.domain.security.boundary.RoleService;
import pl.ug.virtualofficebackend.domain.security.entity.Role;
import pl.ug.virtualofficebackend.domain.security.internal.repository.RoleRepository;

import javax.validation.Valid;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(@Valid Role role) {
        return this.roleRepository.save(role);
    }

    public List<Role> save(@Valid List<Role> roles) {
        return this.roleRepository.saveAll(roles);
    }

    public Role get(long id) {
        return this.roleRepository.findById(id).orElse(null);
    }

    public List<Role> getAll() {
        return this.roleRepository.findAll();
    }

    public Role put(long id, @Valid Role role) {
        role.setId(id);
        return this.roleRepository.save(role);
    }

    public void delete(long id) {
        this.roleRepository.deleteById(id);
    }
}
