package io.java.Book;

import io.java.Course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {
	@Id
	private Long id;
	private String title;
	private String description;

	@OneToOne
	private Course course;

}
