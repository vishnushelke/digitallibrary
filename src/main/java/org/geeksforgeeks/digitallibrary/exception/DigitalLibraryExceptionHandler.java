package org.geeksforgeeks.digitallibrary.exception;


import org.geeksforgeeks.digitallibrary.exception.book.BookNotFoundException;
import org.geeksforgeeks.digitallibrary.exception.book.DuplicateBookException;
import org.geeksforgeeks.digitallibrary.exception.bookIssue.BookAlreadyIssuedException;
import org.geeksforgeeks.digitallibrary.exception.bookIssue.BookIssueLimitExceeded;
import org.geeksforgeeks.digitallibrary.exception.user.*;
import org.geeksforgeeks.digitallibrary.models.DigitalLibraryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.geeksforgeeks.digitallibrary.utils.Constants.FAILURE_STATUS;

@RestControllerAdvice
public class DigitalLibraryExceptionHandler extends RuntimeException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleGlobalException(Exception e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleDuplicateUserException(DuplicateUserException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InActiveUserException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleInActiveUserException(InActiveUserException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyActiveException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleUserAlreadyActiveException(UserAlreadyActiveException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyInActiveException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleUserAlreadyInActiveException(UserAlreadyInActiveException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleDuplicateBookException(DuplicateBookException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleBookNotFoundException(BookNotFoundException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    ////////////////////////
    //// Book Issue ////////
    ////////////////////////

    @ExceptionHandler(BookIssueLimitExceeded.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleBookIssueLimitExceeded(BookIssueLimitExceeded e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BookAlreadyIssuedException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleBookAlreadyIssuedException(BookAlreadyIssuedException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
