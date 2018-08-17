package com.epam.task1.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Group {

    @Id
    @GeneratedValue
    Long id;
    @NotNull
    String name;

    List<User> users;

    int version;
    LocalDate createdDate;
    LocalDate updatedDate;
    String createdUser;
    String updatedUser;
}
