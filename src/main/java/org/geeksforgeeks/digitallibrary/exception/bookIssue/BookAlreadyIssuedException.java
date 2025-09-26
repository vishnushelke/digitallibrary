package org.geeksforgeeks.digitallibrary.exception.bookIssue;

public class BookAlreadyIssuedException extends RuntimeException {
    public BookAlreadyIssuedException(String message) {
        super(message);
    }
}
