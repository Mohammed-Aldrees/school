package io.java.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    public List<Book> findByCourseId(Long courseId);
}
