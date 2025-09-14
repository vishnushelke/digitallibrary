package org.geeksforgeeks.digitallibrary.exception.book;

public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException() {
        super("Book Already Present");
    }
}
