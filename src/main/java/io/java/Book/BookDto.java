package io.java.Book;
import io.java.Course.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDto {
    private Long id;
    @NotNull(message = "title shouldn't be null")
    private String title;
    @NotBlank(message = "description shouldn't be null")
    private String description;
}
