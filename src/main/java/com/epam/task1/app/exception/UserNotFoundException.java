package com.epam.task1.app.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Long userId;

    public UserNotFoundException(final Long userId, final Throwable th) {
        super(th);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
