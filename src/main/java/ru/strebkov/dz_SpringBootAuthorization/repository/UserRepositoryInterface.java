package ru.strebkov.dz_SpringBootAuthorization.repository;

import ru.strebkov.dz_SpringBootAuthorization.model.Authorities;

import java.util.List;

public interface UserRepositoryInterface {
    public List<Authorities> getUserAuthorities(String user, String password);
}
