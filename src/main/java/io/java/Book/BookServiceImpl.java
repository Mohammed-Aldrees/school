package io.java.Book;

import io.java.Converter.Converter;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final BookRepository bookRepository;
	private final Converter converter;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository, Converter converter) {
		this.bookRepository = bookRepository;
		this.converter = converter;
	}

	public List<BookDto> getAll(Long id){
		logger.info("getAll method in BookServiceImpl was accessed");
		List<Book> res = bookRepository.findByCourseId(id);
		return converter.toList(res, BookDto.class);
	}

	public BookDto getById(Long id) throws EntityNotFoundException {
		logger.info("getBook method in BookServiceImpl was accessed");
			Book res = bookRepository.getReferenceById(id);
				return converter.convert(res, BookDto.class);
	}

	public void addBook(Book book) {
		logger.info("addBook method in BookServiceImpl was accessed");
		bookRepository.save(book);
	}

	public void updateBook(Long id, Book book) {
		logger.info("updateBook method in BookServiceImpl was accessed");
		bookRepository.save(book);
	}

	public void deleteBook(Long id) {
		logger.info("deleteBook method in BookServiceImpl was accessed");
		bookRepository.deleteById(id);
	}
}
