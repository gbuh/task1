package com.epam.task1.app.service.impl;

import com.epam.task1.app.entity.Groups;
import com.epam.task1.app.repository.impl.H2GroupRepository;
import com.epam.task1.app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private H2GroupRepository groupRepository;

    @Override
    public Groups getById(Long id) {
        return groupRepository.getOne(id);
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
    public void update(Long id, Groups Groups) {
        if (groupRepository.existsById(id)) {
            // TODO????
        } else
            insert(Groups);
    }

    @Override
    public void insert(Groups Groups) {
        groupRepository.save(Groups);
    }
}
