package io.java.Course;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface CourseService {
    public List<CourseDto> getAll();
    public CourseDto getById(Long id) throws EntityNotFoundException;
    public void addCourse(Course course);
    public void updateCourse(Long id, Course course);
    public void deleteCourse(Long id);
}
