package io.java.Teacher;

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
@Table(name = "teacher")
public class Teacher {
	@Id
	private Long id;
	private String name;
	private String email;
	private String password;
	private Integer age;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade= CascadeType.DETACH)
	private Course course;

}
