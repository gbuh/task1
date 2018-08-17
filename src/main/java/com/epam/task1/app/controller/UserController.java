package com.epam.task1.app.controller;

import com.epam.task1.app.domain.User;
import com.epam.task1.app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    User user(Long id) {
        return userService.getById(id);
    }

    @GetMapping
    Collection<User> users() {
        return userService.getAll();
    }

    @PostMapping
    String createUser(User user) {
        userService.insert(user);
        return "redirect:/users";
    }

    @PostMapping
    String deleteUser(Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PostMapping
    String updateUser(Long id, User user) {
        userService.update(id, user);
        return "redirect:/users";
    }
}
