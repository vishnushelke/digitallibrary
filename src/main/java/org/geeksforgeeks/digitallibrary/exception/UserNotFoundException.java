package org.geeksforgeeks.digitallibrary.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User Not Found With Provided Information");
    }
}
