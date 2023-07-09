package io.java.Book;

import io.java.Course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne(cascade=CascadeType.ALL)
	private Course course;

}
