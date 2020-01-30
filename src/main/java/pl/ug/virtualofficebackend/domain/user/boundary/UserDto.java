package pl.ug.virtualofficebackend.domain.user.boundary;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class UserDto {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String matchingPassword;
    private String email;
    private String country;
    private String picUrl;
    private LocalDateTime joined;

    public UserDto() {
    }

    public UserDto(
            @NotBlank String username,
            @NotBlank String name,
            @NotBlank String surname,
            @NotBlank String password,
            String matchingPassword,
            @NotBlank String email) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public UserDto(
            @NotBlank String username,
            @NotBlank String name,
            @NotBlank String surname,
            @NotBlank String password,
            String matchingPassword,
            @NotBlank String email,
            String picUrl) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
        this.picUrl = picUrl;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotBlank
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public LocalDateTime getJoined() {
        return joined;
    }

    public void setJoined(LocalDateTime joined) {
        this.joined = joined;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}