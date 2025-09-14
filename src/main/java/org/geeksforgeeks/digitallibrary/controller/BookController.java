package org.geeksforgeeks.digitallibrary.controller;


import org.geeksforgeeks.digitallibrary.dto.BookDto;
import org.geeksforgeeks.digitallibrary.models.DigitalLibraryResponse;
import org.geeksforgeeks.digitallibrary.service.core.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.geeksforgeeks.digitallibrary.utils.Constants.SUCCESS_STATUS;

@RestController
@RequestMapping("/book")
public class BookController {

    private final IBookService service;

    public BookController(IBookService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<DigitalLibraryResponse<BookDto>> createBook(@RequestBody BookDto book) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.addBook(book), null), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigitalLibraryResponse<BookDto>> getBook(@PathVariable("id") long id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.getBookById(id), null), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<DigitalLibraryResponse<BookDto>> updateBook(@PathVariable long id, @RequestBody BookDto book) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.updateBook(id, book), null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DigitalLibraryResponse<String>> deleteBook(@PathVariable("id") long id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.removeBookById(id), null), HttpStatus.OK);
    }
}
