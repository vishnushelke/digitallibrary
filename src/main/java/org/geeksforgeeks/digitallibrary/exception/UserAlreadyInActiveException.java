package org.geeksforgeeks.digitallibrary.exception;

public class UserAlreadyInActiveException extends RuntimeException {
    public UserAlreadyInActiveException() {
        super("User Already InActive");
    }
}
