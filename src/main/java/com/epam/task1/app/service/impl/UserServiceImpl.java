package com.epam.task1.app.service.impl;

import com.epam.task1.app.entity.User;
import com.epam.task1.app.repository.impl.H2UserRepository;
import com.epam.task1.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private H2UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(Long id, User user) {
        if (userRepository.existsById(id)) {
            // TODO????
        } else
            insert(user);
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }
}
