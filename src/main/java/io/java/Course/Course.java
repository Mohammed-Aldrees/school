package io.java.Course;

import io.java.Student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "course")
public class Course {
	@Id
	private Long id;
	private String title;
	private String description;

	public Course(Long id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	@ManyToMany
	@JoinTable(name = "course_student",
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
			)
	private List<Student> students;


}
