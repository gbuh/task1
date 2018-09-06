package com.company.task1.app.controller;

import com.company.task1.app.entity.User;
import com.company.task1.app.service.api.UserService;
import lombok.Setter;
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
public class UserController {

    @Autowired
    @Setter
    private UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<User> user(@PathVariable final Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public Collection<User> users() {
        return userService.getAll();
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String create(@RequestBody final User user) {
        userService.insert(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") final Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PutMapping("/update")
    public String update(@RequestBody final User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
