package org.geeksforgeeks.digitallibrary.exception;

public class DuplicateUser extends RuntimeException {
    public DuplicateUser() {
        super("User Already Present With This Email");
    }
}
