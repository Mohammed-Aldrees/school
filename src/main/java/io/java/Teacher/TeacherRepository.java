package io.java.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    public List<Teacher> findByCourseId(Long courseId);

}
