package io.java.Course;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

	private CourseService courseServiceImpl;
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

	@GetMapping("/Course/{Id}")
	public CourseDto getCourse(@PathVariable Long Id) throws EntityNotFoundException {
		return courseServiceImpl.getById(Id);
	}

	@PostMapping("/Courses")
	public void addCourse(@Valid @RequestBody Course course){
		courseServiceImpl.addCourse(course);
	}

	@PutMapping("/Course/{Id}")
	public void updateCourse(@RequestBody Course course, @PathVariable Long Id){
		courseServiceImpl.updateCourse(Id,course);
	}

	@DeleteMapping("/Course/{Id}")
	public void deleteCourse(@PathVariable Long Id){
		courseServiceImpl.deleteCourse(Id);
	}

}
