package org.geeksforgeeks.digitallibrary.exception.user;

public class UserAlreadyActiveException extends RuntimeException {
    public UserAlreadyActiveException() {
        super("User Already Active");
    }
}
