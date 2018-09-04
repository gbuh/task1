package com.company.task1.app.service.api;

import com.company.task1.app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getById(Long id);

    List<User> getAll();

    void delete(Long id);

    void update(User user);

    void insert(User user);
}
