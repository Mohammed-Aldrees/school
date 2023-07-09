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

	private TeacherService teacherServiceImpl;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public TeacherController(TeacherService teacherServiceImpl) {
		this.teacherServiceImpl = teacherServiceImpl;
	}
	@GetMapping("/Course/{id}/Teachers")
	public List<TeacherDto>getAll(@PathVariable Long id){
		return teacherServiceImpl.getAll(id);
	}

	@GetMapping("/Course/{courseId}/Teacher/{Id}")
	public TeacherDto getTeacher(@PathVariable Long Id) throws EntityNotFoundException {
		return teacherServiceImpl.getById(Id);
	}

	@PostMapping("/Course/{id}/Teachers")
	public void addTeacher(@Valid @RequestBody Teacher teacher,@PathVariable Long id){
		teacher.setCourse(new Course(id,"",""));
		teacherServiceImpl.addTeacher(teacher);
	}

	@PutMapping("/Course/{courseId}/Teacher/{teacherId}")
	public void updateTeacher(@RequestBody Teacher teacher,@PathVariable Long courseId,@PathVariable Long teacherId){
		teacher.setCourse(new Course(courseId,"",""));
		teacherServiceImpl.updateTeacher(teacherId,teacher);
	}

	@DeleteMapping("/Course/{courseId}/Teacher/{Id}")
	public void deleteTeacher(@PathVariable Long Id){
		teacherServiceImpl.deleteTeacher(Id);
	}

}
