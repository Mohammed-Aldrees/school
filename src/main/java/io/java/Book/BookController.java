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

	private BookService bookServiceImpl;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public BookController(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}
	@GetMapping("/Course/{id}/Books")
	public List<BookDto>getAll(@PathVariable Long id){
		return bookServiceImpl.getAll(id);
	}

	@GetMapping("/Course/{CourseId}/Book/{Id}")
	public BookDto getBook(@PathVariable Long Id) throws EntityNotFoundException {
		return bookServiceImpl.getById(Id);
	}

	@PostMapping("/Course/{id}/Books")
	public void addBook(@Valid @RequestBody Book book,@PathVariable Long id){
		book.setCourse(new Course(id,"",""));
		bookServiceImpl.addBook(book);
	}

	@PutMapping("/Course/{CourseId}/Book/{BookId}")
	public void updateBook(@RequestBody Book book, @PathVariable Long CourseId,@PathVariable Long BookId ){
		book.setCourse(new Course(CourseId,"",""));
		bookServiceImpl.updateBook(BookId,book);
	}

	@DeleteMapping("/Course/{CourseId}/Book/{Id}")
	public void deleteBook(@PathVariable Long Id){
		bookServiceImpl.deleteBook(Id);
	}

}
