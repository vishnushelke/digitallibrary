package org.geeksforgeeks.digitallibrary.controller;

import org.geeksforgeeks.digitallibrary.dao.BookIssueCount;
import org.geeksforgeeks.digitallibrary.dto.BookIssueDto;
import org.geeksforgeeks.digitallibrary.models.DigitalLibraryResponse;
import org.geeksforgeeks.digitallibrary.service.core.IBookIssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.geeksforgeeks.digitallibrary.utils.Constants.SUCCESS_STATUS;

@RestController
@RequestMapping("/book_issue")
public class BookIssueController {

    private IBookIssueService service;

    public BookIssueController(IBookIssueService service) {
        this.service = service;
    }

    @PostMapping("/issue")
    public ResponseEntity<DigitalLibraryResponse<BookIssueDto>> issueBook(@RequestBody BookIssueDto bookIssueDto) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.issueBook(bookIssueDto), null), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<DigitalLibraryResponse<List<BookIssueDto>>> getActiveBooksIssuedForUser(@PathVariable long id) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.getActiveBooksIssuedForUser(id), null), HttpStatus.OK);
    }

    @GetMapping("/top/{n}")
    public ResponseEntity<DigitalLibraryResponse<List<BookIssueCount>>> getTopNBooks(@PathVariable int n) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(SUCCESS_STATUS, this.service.topNUsedBooks(n), null), HttpStatus.OK);
    }
}
