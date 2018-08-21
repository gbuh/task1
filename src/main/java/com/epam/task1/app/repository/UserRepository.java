package com.epam.task1.app.repository;

import com.epam.task1.app.entity.User;
import java.util.List;

public interface UserRepository {

    User getById(Long id);

    List<User> findAll();

    void delete(Long id);

    void update(User user);

    void insert(User user);
}
