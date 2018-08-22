package com.epam.task1.app.service;

import com.epam.task1.app.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<Users> getById(Long id);

    List<Users> getAll();

    void delete(Long id);

    void update(Users user);

    void insert(Users user);
}
