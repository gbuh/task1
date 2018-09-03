package com.epam.task1.app.repository.api;

import com.epam.task1.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
