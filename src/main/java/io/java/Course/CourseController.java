package io.java.Course;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

	private final CourseService courseServiceImpl;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public CourseController(CourseService courseServiceImpl) {
		this.courseServiceImpl = courseServiceImpl;
	}
	@GetMapping("/Courses")
	public List<CourseDto>getAll(){
		return courseServiceImpl.getAll();
	}

	@GetMapping("/Course/{courseId}")
	public CourseDto getCourse(@PathVariable Long courseId) throws EntityNotFoundException {
		return courseServiceImpl.getById(courseId);
	}

	@PostMapping("/Courses")
	public void addCourse(@Valid @RequestBody Course course){
		courseServiceImpl.addCourse(course);
	}

	@PutMapping("/Course/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable Long courseId){
		courseServiceImpl.updateCourse(courseId,course);
	}

	@DeleteMapping("/Course/{courseId}")
	public void deleteCourse(@PathVariable Long courseId){
		courseServiceImpl.deleteCourse(courseId);
	}

}
