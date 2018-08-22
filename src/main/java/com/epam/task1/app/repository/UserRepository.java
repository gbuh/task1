package com.epam.task1.app.repository;

import com.epam.task1.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
