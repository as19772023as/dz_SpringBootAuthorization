package ru.strebkov.dz_SpringBootAuthorization.repository;

import org.springframework.stereotype.Repository;
import ru.strebkov.dz_SpringBootAuthorization.model.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {

    @Override
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("Ana") && password.equals("123")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        }
        return authorities;
    }
}


