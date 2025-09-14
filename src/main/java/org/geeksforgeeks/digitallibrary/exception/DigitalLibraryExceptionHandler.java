package org.geeksforgeeks.digitallibrary.exception;


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

    @ExceptionHandler(DuplicateUser.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleDuplicateUserException(DuplicateUser e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InActiveUserException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleInActiveUserException(InActiveUserException e){
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyActiveException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleUserAlreadyActiveException(UserAlreadyActiveException e){
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyInActiveException.class)
    public ResponseEntity<DigitalLibraryResponse<?>> handleUserAlreadyInActiveException(UserAlreadyInActiveException e){
        return new ResponseEntity<>(new DigitalLibraryResponse<>(FAILURE_STATUS, null, e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
