package io.java.Student;

import io.java.Course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "student")
public class Student {
	@Id
	private Long id;
	private String name;
	private String email;
	private String password;
	private Integer age;

	@ManyToMany(mappedBy = "students")
	private List<Course> courses;

}
