package org.geeksforgeeks.digitallibrary.exception;

public class InActiveUserException extends RuntimeException {
    public InActiveUserException() {
        super("User is Inactive");
    }
}
