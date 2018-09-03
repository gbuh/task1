package com.epam.task1.app.service.api;

import com.epam.task1.app.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Optional<Group> getById(Long id);

    List<Group> getAll();

    void delete(Long id);

    void update(Group group);

    void insert(Group group);
}
