package com.epam.task1.app.controller;

import com.epam.task1.app.entity.Groups;
import com.epam.task1.app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    Groups Groups(Long id) {
        return groupService.getById(id);
    }

    @GetMapping
    Collection<Groups> groups() {
        return groupService.getAll();
    }

    @PostMapping("/create")
    String create(Groups Groups) {
        groupService.insert(Groups);
        return "redirect:/groups";
    }

    @PostMapping("/delete")
    String delete(Long id) {
        groupService.delete(id);
        return "redirect:/groups";
    }

    @PostMapping("/update")
    String update(Long id, Groups Groups) {
        groupService.update(id, Groups);
        return "redirect:/groups";
    }
}
