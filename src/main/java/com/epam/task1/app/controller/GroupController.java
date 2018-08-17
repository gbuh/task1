package com.epam.task1.app.controller;

import com.epam.task1.app.domain.Group;
import com.epam.task1.app.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/groups")
public class GroupController {

    GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    Group group(Long id) {
        return groupService.getById(id);
    }

    @GetMapping
    Collection<Group> groups() {
        return groupService.getAll();
    }

    @PostMapping
    String createGroup(Group group) {
        groupService.insert(group);
        return "redirect:/groups";
    }

    @PostMapping
    String deleteGroup(Long id) {
        groupService.delete(id);
        return "redirect:/groups";
    }

    @PostMapping
    String updateGroup(Long id, Group group) {
        groupService.update(id, group);
        return "redirect:/groups";
    }
}
