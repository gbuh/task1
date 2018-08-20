package com.epam.task1.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Group extends AbstractEntity {

    private static final long serialVersionUID = 1L;

/*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
*/
    @NotNull
    private String name;

    //private List<User> users;

    private int version;

    private LocalDate createdDate;

    private LocalDate updatedDate;

    private String createdUser;

    private String updatedUser;
}
