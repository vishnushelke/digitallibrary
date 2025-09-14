package org.geeksforgeeks.digitallibrary.service.core;

import org.geeksforgeeks.digitallibrary.dto.BookDto;
import org.geeksforgeeks.digitallibrary.dto.CreateUserDto;
import org.geeksforgeeks.digitallibrary.dto.UpdateUserDto;

import java.awt.print.Book;

public interface IBookService {

    BookDto addBook(BookDto bookDto);

    BookDto getBookById(long id);

    BookDto updateBook(long id, BookDto bookDto);

    String removeBookById(long id);

}
