package com.epam.task1.app.service.impl;

import com.epam.task1.app.entity.User;
import com.epam.task1.app.repository.api.UserRepository;
import com.epam.task1.app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getById(final Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(final User user) {
        userRepository.save(user);
    }

    @Override
    public void insert(final User user) {
        userRepository.save(user);
    }
}
