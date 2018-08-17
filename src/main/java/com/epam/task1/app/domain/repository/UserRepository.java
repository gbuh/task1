package com.epam.task1.app.domain.repository;

import com.epam.task1.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
