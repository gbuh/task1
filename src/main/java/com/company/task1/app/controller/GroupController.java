package com.company.task1.app.controller;

import com.company.task1.app.entity.Group;
import com.company.task1.app.service.api.GroupService;
import lombok.Setter;
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
@RequestMapping("/groups")
@Log4j2
public class GroupController {

    @Autowired
    @Setter
    private GroupService groupService;

    public GroupController(final GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public Optional<Group> groups(@PathVariable final Long id) {
        log.info("Request to get group by id: {}", id);
        return groupService.getById(id);
    }

    @GetMapping
    public Collection<Group> groups() {
        log.info("Request to get all groups");
        return groupService.getAll();
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String create(@RequestBody final Group group) {
        log.info("Request to create group: {}", group);
        groupService.insert(group);
        return "redirect:/groups";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") final Long id) {
        log.info("Request to delete group with id: {}", id);
        groupService.delete(id);
        return "redirect:/groups";
    }

    @PutMapping("/update")
    public String update(@RequestBody final Group groups) {
        log.info("Request to update user: {}", groups);
        groupService.update(groups);
        return "redirect:/groups";
    }
}
