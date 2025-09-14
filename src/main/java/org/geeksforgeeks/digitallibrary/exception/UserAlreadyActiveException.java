package org.geeksforgeeks.digitallibrary.exception;

public class UserAlreadyActiveException extends RuntimeException {
    public UserAlreadyActiveException() {
        super("User Already Active");
    }
}
