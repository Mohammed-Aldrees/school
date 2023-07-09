package io.java.Student;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

	private StudentService studentServiceImpl;
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

	@GetMapping("/Student/{Id}")
	public StudentDto getStudent(@PathVariable Long Id) throws EntityNotFoundException {
		return studentServiceImpl.getById(Id);
	}

	@PostMapping("/Students")
	public void addStudent(@Valid @RequestBody Student student){
		studentServiceImpl.addStudent(student);
	}

	@PutMapping("/Student/{Id}")
	public void updateStudent(@RequestBody Student student, @PathVariable Long Id){
		studentServiceImpl.updateStudent(Id,student);
	}

	@DeleteMapping("/Student/{Id}")
	public void deleteStudent(@PathVariable Long Id){
		studentServiceImpl.deleteStudent(Id);
	}

}
