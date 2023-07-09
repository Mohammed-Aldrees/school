package io.java.Teacher;

import io.java.Course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	private Long id;
	private String name;
	private String email;
	private String password;
	private Integer age;
	@ManyToOne
	private Course course;

}
