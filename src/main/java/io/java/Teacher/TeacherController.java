package io.java.Teacher;

import io.java.Course.Course;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

	private final TeacherService teacherServiceImpl;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public TeacherController(TeacherService teacherServiceImpl) {
		this.teacherServiceImpl = teacherServiceImpl;
	}
	@GetMapping("/Course/{courseId}/Teachers")
	public List<TeacherDto>getAll(@PathVariable Long courseId){
		return teacherServiceImpl.getAll(courseId);
	}

	@GetMapping("/Course/{courseId}/Teacher/{teacherId}")
	public TeacherDto getTeacher(@PathVariable Long teacherId) throws EntityNotFoundException {
		return teacherServiceImpl.getById(teacherId);
	}

	@PostMapping("/Course/{courseId}/Teachers")
	public void addTeacher(@Valid @RequestBody Teacher teacher,@PathVariable Long courseId){
		teacher.setCourse(new Course(courseId,"",""));
		teacherServiceImpl.addTeacher(teacher);
	}

	@PutMapping("/Course/{courseId}/Teacher/{teacherId}")
	public void updateTeacher(@RequestBody Teacher teacher,@PathVariable Long courseId,@PathVariable Long teacherId){
		teacher.setCourse(new Course(courseId,"",""));
		teacherServiceImpl.updateTeacher(teacherId,teacher);
	}

	@DeleteMapping("/Course/{courseId}/Teacher/{teacherId}")
	public void deleteTeacher(@PathVariable Long teacherId){
		teacherServiceImpl.deleteTeacher(teacherId);
	}

}
