package com.epam.task1.app.controller;

import com.epam.task1.app.entity.User;
import com.epam.task1.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping(path = "/create", consumes = "application/json")
    public String create(@RequestBody User user) {
        userService.insert(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PostMapping("/update")
    String update(User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
