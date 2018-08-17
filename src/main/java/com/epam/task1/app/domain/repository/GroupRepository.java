package com.epam.task1.app.domain.repository;

import com.epam.task1.app.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
