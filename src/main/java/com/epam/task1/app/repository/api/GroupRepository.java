package com.epam.task1.app.repository.api;

import com.epam.task1.app.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
