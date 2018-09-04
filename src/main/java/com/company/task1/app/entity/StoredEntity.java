package com.company.task1.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class StoredEntity extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private int version;
    @Getter
    @Setter
    private LocalDate createDate;
    @Getter
    @Setter
    private LocalDate updateDate;
    @Getter
    @Setter
    private String createdUser;
    @Getter
    @Setter
    private String updatedUser;
}
