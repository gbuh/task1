package com.epam.task1.app.service;

import com.epam.task1.app.entity.Groups;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Optional<Groups> getById(Long id);

    List<Groups> getAll();

    void delete(Long id);

    void update(Groups group);

    void insert(Groups group);
}
