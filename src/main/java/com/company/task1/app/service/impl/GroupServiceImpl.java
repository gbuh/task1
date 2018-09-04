package com.company.task1.app.service.impl;

import com.company.task1.app.entity.Group;
import com.company.task1.app.repository.api.GroupRepository;
import com.company.task1.app.service.api.GroupService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    @Setter
    private GroupRepository groupRepository;

    @Override
    public Optional<Group> getById(final Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public void delete(final Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void update(final Group groups) {
        groupRepository.save(groups);
    }

    @Override
    public void insert(final Group groups) {
        groupRepository.save(groups);
    }
}
