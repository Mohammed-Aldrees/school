package io.java.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentDto {
    private Long id;
    @NotNull(message = "name shouldn't be null")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @Min(17)
    @Max(25)
    private Integer age;

}
