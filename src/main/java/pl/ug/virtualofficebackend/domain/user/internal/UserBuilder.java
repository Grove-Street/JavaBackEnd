package pl.ug.virtualofficebackend.domain.user.internal;

import pl.ug.virtualofficebackend.domain.office.entity.Office;
import pl.ug.virtualofficebackend.domain.security.entity.Role;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.workstation.entity.Workstation;

public final class UserBuilder {
    public String country;
    private long id;
    private String username;
    private String email;
    private String name;
    private String secondName;
    private String password;
    private String surname;
    private Workstation workstation;
    private Office office;
    private Role role;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public UserBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserBuilder withWorkstation(Workstation workstation) {
        this.workstation = workstation;
        return this;
    }

    public UserBuilder withOffice(Office office) {
        this.office = office;
        return this;
    }

    public UserBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public User build() {
        User user = new User();
        user.setCountry(country);
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setName(name);
        user.setSecondName(secondName);
        user.setPassword(password);
        user.setSurname(surname);
        user.setWorkstation(workstation);
        user.setOffice(office);
        user.setRole(role);
        return user;
    }
}
