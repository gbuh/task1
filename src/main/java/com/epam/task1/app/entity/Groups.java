package com.epam.task1.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Groups extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;

    @ManyToMany
    private List<User> users;

    private int version;

    private LocalDate createDate;

    private LocalDate updateDate;

    private String createdUser;

    private String updatedUser;
}
