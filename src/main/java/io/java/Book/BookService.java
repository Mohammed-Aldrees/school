package io.java.Book;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface BookService {
    public List<BookDto> getAll(Long id);
    public BookDto getById(Long id) throws EntityNotFoundException;
    public void addBook(Book book);
    public void updateBook(Long id, Book book);
    public void deleteBook(Long id);
}
