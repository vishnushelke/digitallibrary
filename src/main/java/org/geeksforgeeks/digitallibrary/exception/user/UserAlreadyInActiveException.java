package org.geeksforgeeks.digitallibrary.exception.user;

public class UserAlreadyInActiveException extends RuntimeException {
    public UserAlreadyInActiveException() {
        super("User Already InActive");
    }
}
