package com.lambakean.domain.exception;

public class UserNotLoggedInException extends RuntimeException {
    public UserNotLoggedInException() {
    }

    public UserNotLoggedInException(String message) {
        super(message);
    }
}
