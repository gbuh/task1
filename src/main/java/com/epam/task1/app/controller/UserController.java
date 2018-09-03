package com.epam.task1.app.controller;

import com.epam.task1.app.entity.User;
import com.epam.task1.app.service.api.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<User> user(@PathVariable final Long id) {
        log.info("Request to get user by id: {}", id);
        return userService.getById(id);
    }

    @GetMapping
    public Collection<User> users() {
        log.info("Request to get all users");
        return userService.getAll();
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String create(@RequestBody final User user) {
        log.info("Request to create user: {}", user);
        userService.insert(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") final Long id) {
        log.info("Request to delete user with id: {}", id);
        userService.delete(id);
        return "redirect:/users";
    }

    @PutMapping("/update")
    public String update(@RequestBody final User user) {
        log.info("Request to update user: {}", user);
        userService.update(user);
        return "redirect:/users";
    }
}
