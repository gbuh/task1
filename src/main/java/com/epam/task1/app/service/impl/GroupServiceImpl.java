package com.epam.task1.app.service.impl;

import com.epam.task1.app.entity.Groups;
import com.epam.task1.app.repository.GroupRepository;
import com.epam.task1.app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Optional<Groups> getById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Groups> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void update(Groups groups) {
        groupRepository.save(groups);
    }

    @Override
    public void insert(Groups groups) {
        groupRepository.save(groups);
    }
}
