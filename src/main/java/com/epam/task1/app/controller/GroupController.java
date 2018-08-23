package com.epam.task1.app.controller;

import com.epam.task1.app.entity.Groups;
import com.epam.task1.app.service.GroupService;
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
@RequestMapping("/groups")
public class GroupController {

    private final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    Optional<Groups> groups(Long id) {
        log.info("Request to get group by id: {}", id);
        return groupService.getById(id);
    }

    @GetMapping
    Collection<Groups> groups() {
        log.info("Request to get all groups");
        return groupService.getAll();
    }

    @PostMapping(path = "/create", consumes = "application/json")
    String create(@RequestBody Groups group) {
        log.info("Request to create group: {}", group);
        groupService.insert(group);
        return "redirect:/groups";
    }

    @DeleteMapping("/delete")
    String delete(@RequestParam("id") Long id) {
        log.info("Request to delete group with id: {}", id);
        groupService.delete(id);
        return "redirect:/groups";
    }

    @PutMapping("/update")
    String update(@RequestBody Groups groups) {
        log.info("Request to update user: {}", groups);
        groupService.update(groups);
        return "redirect:/groups";
    }
}
