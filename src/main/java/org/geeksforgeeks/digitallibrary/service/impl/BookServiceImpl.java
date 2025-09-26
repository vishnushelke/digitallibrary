package org.geeksforgeeks.digitallibrary.service.impl;

import org.geeksforgeeks.digitallibrary.dto.BookDto;
import org.geeksforgeeks.digitallibrary.entity.BookEntity;
import org.geeksforgeeks.digitallibrary.exception.book.BookNotFoundException;
import org.geeksforgeeks.digitallibrary.exception.book.DuplicateBookException;
import org.geeksforgeeks.digitallibrary.repository.impl.BookRepository;
import org.geeksforgeeks.digitallibrary.service.core.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository repository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        if(this.repository.getAllBooks().stream().anyMatch(b -> b.getName().equals(bookDto.getName()) && b.getAuthor().equals(bookDto.getAuthor())))
            throw new DuplicateBookException();
        BookEntity entity = this.modelMapper.map(bookDto, BookEntity.class);
        this.repository.addBook(entity);
        return bookDto;
    }

    @Override
    public BookDto getBookById(long id) {
        BookEntity entity =  this.repository.getBookById(id).orElseThrow(BookNotFoundException::new);
        return this.modelMapper.map(entity, BookDto.class);
    }

    @Override
    public BookDto updateBook(long id, BookDto bookDto) {
        this.repository.getBookById(id).orElseThrow(BookNotFoundException::new);
        BookEntity toBeUpdated = this.modelMapper.map(bookDto, BookEntity.class);
        toBeUpdated.setId(id);
        this.repository.updateBook(toBeUpdated);
        return bookDto;
    }

    @Override
    public String removeBookById(long id) {
        return this.repository.removeBookById(id);
    }
}
