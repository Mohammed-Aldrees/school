package io.java.Student;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

	private final StudentService studentServiceImpl;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	public StudentController(StudentService studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}
	@GetMapping("/Students")
	public List<StudentDto>getAll(){
		return studentServiceImpl.getAll();
	}

	@GetMapping("/Student/{studentId}")
	public StudentDto getStudent(@PathVariable Long studentId) throws EntityNotFoundException {
		return studentServiceImpl.getById(studentId);
	}

	@PostMapping("/Students")
	public void addStudent(@Valid @RequestBody Student student){
		studentServiceImpl.addStudent(student);
	}

	@PutMapping("/Student/{studentId}")
	public void updateStudent(@RequestBody Student student, @PathVariable Long studentId){
		studentServiceImpl.updateStudent(studentId,student);
	}

	@DeleteMapping("/Student/{studentId}")
	public void deleteStudent(@PathVariable Long studentId){
		studentServiceImpl.deleteStudent(studentId);
	}

}
