package com.epam.task1.app.controller;

import com.epam.task1.app.entity.User;
import com.epam.task1.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

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

    @PostMapping("/create")
    String create(User user) {
        userService.insert(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    String delete(Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    String update(Long id, User user) {
        userService.update(id, user);
        return "redirect:/users";
    }
}
