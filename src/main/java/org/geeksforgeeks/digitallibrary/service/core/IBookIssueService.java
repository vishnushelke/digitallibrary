package org.geeksforgeeks.digitallibrary.service.core;

import org.geeksforgeeks.digitallibrary.dao.BookIssueCount;
import org.geeksforgeeks.digitallibrary.dto.BookIssueDto;

import java.util.List;

public interface IBookIssueService {

    BookIssueDto issueBook(BookIssueDto dto);

    List<BookIssueDto> getActiveBooksIssuedForUser(long id);

    List<BookIssueCount> topNUsedBooks(int n);
}
