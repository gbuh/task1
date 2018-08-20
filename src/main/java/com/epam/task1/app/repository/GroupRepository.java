package com.epam.task1.app.repository;

import com.epam.task1.app.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Groups, Long> {

}
