package org.geeksforgeeks.digitallibrary.service.core;

import org.geeksforgeeks.digitallibrary.dto.BookIssueDto;

public interface IBookIssueService {

    BookIssueDto issueBook(BookIssueDto dto);
}
