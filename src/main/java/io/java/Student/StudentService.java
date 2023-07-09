package io.java.Student;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

public interface StudentService {
    public List<StudentDto> getAll();
    public StudentDto getById(Long id) throws EntityNotFoundException;
    public void addStudent(Student student);
    public void updateStudent(Long id, Student student);
    public void deleteStudent(Long id);
}
