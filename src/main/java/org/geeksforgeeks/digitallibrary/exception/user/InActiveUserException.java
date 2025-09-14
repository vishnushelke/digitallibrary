package org.geeksforgeeks.digitallibrary.exception.user;

public class InActiveUserException extends RuntimeException {
    public InActiveUserException() {
        super("User is Inactive");
    }
}
