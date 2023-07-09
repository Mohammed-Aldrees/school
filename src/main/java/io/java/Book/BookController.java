package io.java.Book;

import io.java.Course.Course;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

	private final BookService bookServiceImpl;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public BookController(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}
	@GetMapping("/Course/{courseId}/Books")
	public List<BookDto>getAll(@PathVariable Long courseId){
		return bookServiceImpl.getAll(courseId);
	}

	@GetMapping("/Course/{courseId}/Book/{bookId}")
	public BookDto getBook(@PathVariable Long bookId) throws EntityNotFoundException {
		return bookServiceImpl.getById(bookId);
	}

	@PostMapping("/Course/{courseId}/Books")
	public void addBook(@Valid @RequestBody Book book,@PathVariable Long courseId){
		book.setCourse(new Course(courseId,"",""));
		bookServiceImpl.addBook(book);
	}

	@PutMapping("/Course/{courseId}/Book/{bookId}")
	public void updateBook(@RequestBody Book book, @PathVariable Long courseId,@PathVariable Long bookId ){
		book.setCourse(new Course(courseId,"",""));
		bookServiceImpl.updateBook(bookId,book);
	}

	@DeleteMapping("/Course/{courseId}/Book/{bookId}")
	public void deleteBook(@PathVariable Long bookId){
		bookServiceImpl.deleteBook(bookId);
	}

}
