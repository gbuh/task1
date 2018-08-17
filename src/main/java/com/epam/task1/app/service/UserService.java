package com.epam.task1.app.service;

import com.epam.task1.app.domain.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);

    void update(Long id, User user);

    void insert(User user);
}
