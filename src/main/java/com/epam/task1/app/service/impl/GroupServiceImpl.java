package com.epam.task1.app.service.impl;

import com.epam.task1.app.domain.Group;
import com.epam.task1.app.domain.repository.GroupRepository;
import com.epam.task1.app.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;

    @Override
    public Group getById(Long id) {
        return groupRepository.getOne(id);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Group group) {
        if (groupRepository.existsById(id)) {
            // TODO????
        } else
            insert(group);
    }

    @Override
    public void insert(Group group) {
        groupRepository.save(group);
    }
}
