package com.epam.task1.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private int version;

    private LocalDate createDate;

    private LocalDate updateDate;

    private String createdUser;

    private String updatedUser;
}
