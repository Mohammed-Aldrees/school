package io.java.Student;

import io.java.Converter.Converter;
import io.java.Course.Course;
import io.java.Course.CourseRepository;
import io.java.Course.CourseService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final Converter converter;
	private final CourseService courseService;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, Converter converter, CourseService courseService) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.converter = converter;
		this.courseService = courseService;
	}

	public List<StudentDto> getAll(){
		logger.info("getAll method in StudentServiceImpl was accessed");
		List<Student> res = studentRepository.findAll();
		return converter.toList(res, StudentDto.class);
	}

	public StudentDto getById(Long id) throws EntityNotFoundException {
		logger.info("getStudent method in StudentServiceImpl was accessed");
			Student res = studentRepository.getReferenceById(id);
				return converter.convert(res, StudentDto.class);
	}

	public void addStudent(Student student) {
		logger.info("addStudent method in StudentServiceImpl was accessed");
		studentRepository.save(student);
	}

	public void updateStudent(Long id, Student student) {
		logger.info("updateStudent method in StudentServiceImpl was accessed");
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		logger.info("deleteStudent method in StudentServiceImpl was accessed");
		List<Course> courses = courseRepository.findAll();
		Student student = studentRepository.getReferenceById(id);
		courses.forEach(course -> {
			if(course.getStudents().remove(student)){
				courseService.updateCourse(course.getId(),course);
			}
		});
		studentRepository.deleteById(id);
	}
}
