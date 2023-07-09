package io.java.Course;

import io.java.Student.StudentDto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseDto {
    private Long id;
    @NotNull(message = "title shouldn't be null")
    private String title;
    @NotBlank(message = "description shouldn't be null")
    private String description;
    private List<StudentDto> students;
}
