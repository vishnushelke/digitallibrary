package org.geeksforgeeks.digitallibrary.exception.user;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException() {
        super("User Already Present With This Email");
    }
}
