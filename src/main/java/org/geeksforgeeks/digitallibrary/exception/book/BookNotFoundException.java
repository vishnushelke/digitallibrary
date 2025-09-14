package org.geeksforgeeks.digitallibrary.exception.book;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book Not Found With Provided Information");
    }
}
