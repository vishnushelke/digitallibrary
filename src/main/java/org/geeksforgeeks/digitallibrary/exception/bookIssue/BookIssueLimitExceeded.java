package org.geeksforgeeks.digitallibrary.exception.bookIssue;

public class BookIssueLimitExceeded extends RuntimeException {
    public BookIssueLimitExceeded(String message) {
        super(message);
    }
}
