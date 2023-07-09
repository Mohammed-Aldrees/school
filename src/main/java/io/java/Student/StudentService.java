package io.java.Student;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getAll();
    public StudentDto getById(Long id) throws EntityNotFoundException;
    public void addStudent(StudentDto studentdto);
    public void updateStudent(Long id, StudentDto studentDto);
    public void deleteStudent(Long id);
}
