package com.epam.task1.app.service.impl;

import com.epam.task1.app.entity.User;
import com.epam.task1.app.repository.UserRepository;
import com.epam.task1.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void update(User user) {
            userRepository.update(user);
    }

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }
}
