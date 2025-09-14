package org.geeksforgeeks.digitallibrary.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User Not Found With Provided Information");
    }
}
