package com.epam.task1.app.controller;

import com.epam.task1.app.entity.Users;
import com.epam.task1.app.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {

    private final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    Optional<Users> user(Long id) {
        log.info("Request to get user by id: {}", id);
        return userService.getById(id);
    }

    @GetMapping
    Collection<Users> users() {
        log.info("Request to get all users");
        return userService.getAll();
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String create(@RequestBody Users user) {
        log.info("Request to create user: {}", user);
        userService.insert(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        log.info("Request to delete user with id: {}", id);
        userService.delete(id);
        return "redirect:/users";
    }

    @PutMapping("/update")
    String update(@RequestBody Users user) {
        log.info("Request to update user: {}", user);
        userService.update(user);
        return "redirect:/users";
    }
}
