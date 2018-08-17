package com.epam.task1.app.service;

import com.epam.task1.app.domain.Group;

import java.util.List;

public interface GroupService {

    Group getById(Long id);

    List<Group> getAll();

    void delete(Long id);

    void update(Long id, Group group);

    void insert(Group group);
}
