package pl.ug.virtualofficebackend.domain.security.boundary;

import pl.ug.virtualofficebackend.domain.security.entity.VerificationToken;
import pl.ug.virtualofficebackend.domain.security.internal.exception.UserDtoValidationException;
import pl.ug.virtualofficebackend.domain.security.internal.exception.WrongTokenException;
import pl.ug.virtualofficebackend.domain.user.boundary.UserDto;
import pl.ug.virtualofficebackend.domain.user.entity.User;

public interface UserSecurityService {
    User registerNewUserAccount(UserDto accountDto) throws UserDtoValidationException, UserDtoValidationException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    void validateVerificationToken(String token) throws WrongTokenException;

    VerificationToken generateNewVerificationToken(final String existingVerificationToken);
}
