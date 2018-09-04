package com.company.task1.app.exception;

import lombok.Getter;
import lombok.Setter;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Long userId;

    public UserNotFoundException(final Long userId, final Throwable th) {
        super(th);
        this.userId = userId;
    }
}
