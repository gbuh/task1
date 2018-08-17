package com.epam.task1.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;

    int version;
    LocalDate createDate;
    LocalDate updateDate;
    String createdUser;
    String updatedUser;
}
