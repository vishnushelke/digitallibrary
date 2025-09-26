package org.geeksforgeeks.digitallibrary.mapper.dto;

import org.geeksforgeeks.digitallibrary.dto.BookIssueDto;
import org.geeksforgeeks.digitallibrary.entity.BookEntity;
import org.geeksforgeeks.digitallibrary.entity.BookIssueEntity;
import org.geeksforgeeks.digitallibrary.entity.UserEntity;
import org.geeksforgeeks.digitallibrary.exception.book.BookNotFoundException;
import org.geeksforgeeks.digitallibrary.exception.user.InActiveUserException;
import org.geeksforgeeks.digitallibrary.exception.user.UserNotFoundException;
import org.geeksforgeeks.digitallibrary.repository.impl.BookRepository;
import org.geeksforgeeks.digitallibrary.repository.impl.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookIssueDtoMapper {

    private BookRepository bookRepository;
    private UserRepository userRepository;

    public BookIssueDtoMapper(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public BookIssueEntity toEntity(BookIssueDto dto) {
        BookEntity bookEntity = this.bookRepository.getBookById(dto.getBookId()).orElseThrow(BookNotFoundException::new);
        UserEntity userEntity = this.userRepository.getById(dto.getUserId()).orElseThrow(UserNotFoundException::new);
        if (!userEntity.isActive()) throw new InActiveUserException();
        LocalDate expiryDate = dto.getIssueDate().plusDays(14);

        return BookIssueEntity.builder().user(userEntity).book(bookEntity).issueDate(dto.getIssueDate()).expiryDate(expiryDate).build();
    }
}
