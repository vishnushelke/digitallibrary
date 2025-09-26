package org.geeksforgeeks.digitallibrary.service.impl;

import org.geeksforgeeks.digitallibrary.dto.BookIssueDto;
import org.geeksforgeeks.digitallibrary.entity.BookIssueEntity;
import org.geeksforgeeks.digitallibrary.enums.SubscriptionType;
import org.geeksforgeeks.digitallibrary.exception.bookIssue.BookAlreadyIssuedException;
import org.geeksforgeeks.digitallibrary.exception.bookIssue.BookIssueLimitExceeded;
import org.geeksforgeeks.digitallibrary.mapper.dto.BookIssueDtoMapper;
import org.geeksforgeeks.digitallibrary.repository.impl.BookIssueRepository;
import org.geeksforgeeks.digitallibrary.service.core.IBookIssueService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookIssueServiceImpl implements IBookIssueService {

    private final BookIssueRepository repository;
    private final BookIssueDtoMapper dtoMapper;
    private final ModelMapper modelMapper;

    public BookIssueServiceImpl(BookIssueRepository repository, BookIssueDtoMapper dtoMapper, ModelMapper modelMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookIssueDto issueBook(BookIssueDto dto) {
        BookIssueEntity entity = dtoMapper.toEntity(dto);

        if (this.repository.getIssuedBookByUserAndBook(entity.getUser(), entity.getBook()).isPresent())
            throw new BookAlreadyIssuedException("Book Already Issued To This User !");

        // Validating if we can add books to user
        List<BookIssueEntity> activeIssueBooks = this.repository.getBooksForUser(entity.getUser()).stream().filter(e -> !isBookIssuedExpired(e)).toList();

        if (!(activeIssueBooks.size() < getAllowedActiveBooksForUser(entity.getUser().getSubscriptionType())))
            throw new BookIssueLimitExceeded("Book issue limit exceeded !");

        BookIssueEntity bookIssue = this.repository.issueBook(entity);
        return this.modelMapper.map(bookIssue, BookIssueDto.class);
    }

    private int getAllowedActiveBooksForUser(SubscriptionType type) {
        int allowedBooks = 0;
        switch (type) {
            case PRO:
                allowedBooks = 7;
                break;
            case PLUS:
                allowedBooks = 3;
                break;
            case PREMIUM:
                allowedBooks = 14;
                break;
            default:
                break;
        }
        return allowedBooks;
    }

    private boolean isBookIssuedExpired(BookIssueEntity entity) {
        return entity.getIssueDate().isAfter(entity.getExpiryDate());
    }
}
