package io.java.Student;

import io.java.Course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

	public Student(Long id, String name, String email, String password, Integer age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
	}
	@OnDelete(action = OnDeleteAction.SET_NULL)
	@ManyToMany(mappedBy = "students")
	private List<Course> courses;

}
