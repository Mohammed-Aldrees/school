package io.java.Course;

import io.java.Converter.Converter;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final CourseRepository courseRepository;
	private final Converter converter;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository, Converter converter) {
		this.courseRepository = courseRepository;
		this.converter = converter;
	}

	public List<CourseDto> getAll(){
		logger.info("getAll method in CourseServiceImpl was accessed");
		List<Course> res = courseRepository.findAll();
		return converter.toList(res, CourseDto.class);
	}

	public CourseDto getById(Long id) throws EntityNotFoundException {
		logger.info("getCourse method in CourseServiceImpl was accessed");
			Course res = courseRepository.getReferenceById(id);
				return converter.convert(res, CourseDto.class);
	}

	public void addCourse(Course course) {
		logger.info("addCourse method in CourseServiceImpl was accessed");
		courseRepository.save(course);
	}

	public void updateCourse(Long id, Course course) {
		logger.info("updateCourse method in CourseServiceImpl was accessed");
		courseRepository.save(course);
	}

	public void deleteCourse(Long id) {
		logger.info("deleteCourse method in CourseServiceImpl was accessed");
		courseRepository.deleteById(id);
	}
}
