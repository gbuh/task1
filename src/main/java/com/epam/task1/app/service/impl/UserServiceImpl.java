package com.epam.task1.app.service.impl;

import com.epam.task1.app.entity.Users;
import com.epam.task1.app.repository.UserRepository;
import com.epam.task1.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Users> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(Users user) {
        userRepository.save(user);
    }

    @Override
    public void insert(Users user) {
        userRepository.save(user);
    }
}
