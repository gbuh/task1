package com.epam.task1.app.service;

import com.epam.task1.app.entity.Groups;

import java.util.List;

public interface GroupService {

    Groups getById(Long id);

    List<Groups> getAll();

    void delete(Long id);

    void update(Long id, Groups group);

    void insert(Groups group);
}
