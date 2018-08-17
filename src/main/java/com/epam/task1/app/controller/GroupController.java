package com.epam.task1.app.controller;

import com.epam.task1.app.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class GroupController {

    UserService groupService;

    public GroupController(UserService groupService) {
        this.groupService = groupService;
    }


}
