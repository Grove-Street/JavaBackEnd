package pl.ug.virtualofficebackend.domain.security.internal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ug.virtualofficebackend.domain.security.boundary.UserSecurityService;
import pl.ug.virtualofficebackend.domain.security.entity.VerificationToken;
import pl.ug.virtualofficebackend.domain.security.internal.exception.UserDtoValidationException;
import pl.ug.virtualofficebackend.domain.security.internal.exception.WrongTokenException;
import pl.ug.virtualofficebackend.domain.security.internal.repository.RoleRepository;
import pl.ug.virtualofficebackend.domain.security.internal.repository.TokenRepository;
import pl.ug.virtualofficebackend.domain.user.boundary.UserDto;
import pl.ug.virtualofficebackend.domain.user.entity.User;
import pl.ug.virtualofficebackend.domain.user.internal.UserBuilder;
import pl.ug.virtualofficebackend.domain.user.internal.UserRepository;

import java.util.Calendar;
import java.util.UUID;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TokenRepository tokenRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserSecurityServiceImpl(UserRepository userRepository, RoleRepository roleRepository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws UserDtoValidationException {
        validateUserDto(accountDto);
        User user = UserBuilder.anUser()
                .withUsername(accountDto.getUsername())
                .withName(accountDto.getName())
                .withSurname(accountDto.getSurname())
                .withPassword(passwordEncoder.encode(accountDto.getPassword()))
                .withRole(roleRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Role not found")))
                .withCountry(accountDto.getCountry())
                .withEmail(accountDto.getEmail())
                .build();
        return userRepository.save(user);
    }

    private void validateUserDto(UserDto accountDto) throws UserDtoValidationException {
        if (checkIfEmailExists(accountDto)) {
            throw new UserDtoValidationException(
                    "There is an account with that email address:" + accountDto.getEmail());
        }
        if (checkIfUsernameExists(accountDto)) {
            throw new UserDtoValidationException(
                    "There is an account with that username: " + accountDto.getUsername());
        }
    }

    private boolean checkIfEmailExists(UserDto userDto) {
        return userRepository.findByEmail(userDto.getEmail()).isPresent();
    }

    private boolean checkIfUsernameExists(UserDto userDto) {
        return userRepository.findByUsername(userDto.getUsername()).isPresent();
    }

    @Override
    public User getUser(String verificationToken) {
        if (verificationToken.startsWith("Bearer ")) {
            verificationToken = verificationToken.replace("Bearer ", "");
        }
        return tokenRepository.findByToken(verificationToken).getUser();
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    @Override
    public void validateVerificationToken(String token) throws WrongTokenException {
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            throw new WrongTokenException(TOKEN_INVALID);
        }
        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if (isExpired(verificationToken, cal)) {
            tokenRepository.delete(verificationToken);
            throw new WrongTokenException(TOKEN_EXPIRED);
        }
        userRepository.save(user);
    }

    private boolean isExpired(VerificationToken verificationToken, Calendar cal) {
        return verificationToken.getExpiryDate()
                .getTime()
                - cal.getTime()
                .getTime() <= 0;
    }

    @Override
    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID()
                .toString());
        vToken = tokenRepository.save(vToken);
        return vToken;
    }

}