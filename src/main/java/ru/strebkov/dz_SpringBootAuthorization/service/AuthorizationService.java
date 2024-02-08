package ru.strebkov.dz_SpringBootAuthorization.service;

import org.springframework.stereotype.Service;
import ru.strebkov.dz_SpringBootAuthorization.exception.InvalidCredentials;
import ru.strebkov.dz_SpringBootAuthorization.exception.UnauthorizedUser;
import ru.strebkov.dz_SpringBootAuthorization.model.Authorities;
import ru.strebkov.dz_SpringBootAuthorization.repository.UserRepositoryInterface;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepositoryInterface userRepository;

    public AuthorizationService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }


    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
