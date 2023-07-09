package io.java.Teacher;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface TeacherService {
    public List<TeacherDto> getAll(Long id);
    public TeacherDto getById(Long id) throws EntityNotFoundException;
    public void addTeacher(Teacher teacher);
    public void updateTeacher(Long id, Teacher teacher);
    public void deleteTeacher(Long id);
}
