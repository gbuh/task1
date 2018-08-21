package com.epam.task1.app.service;

import com.epam.task1.app.entity.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);

    void update(User user);

    void insert(User user);
}
