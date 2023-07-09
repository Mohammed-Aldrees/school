package io.java.Teacher;

import io.java.Converter.Converter;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final TeacherRepository teacherRepository;
	private final Converter converter;

	@Autowired
	public TeacherServiceImpl(TeacherRepository teacherRepository, Converter converter) {
		this.teacherRepository = teacherRepository;
		this.converter = converter;
	}

	public List<TeacherDto> getAll(Long id){
		logger.info("getAll method in TeacherServiceImpl was accessed");
		List<Teacher> res = teacherRepository.findByCourseId(id);
		return converter.toList(res, TeacherDto.class);
	}

	public TeacherDto getById(Long id) throws EntityNotFoundException {
		logger.info("getTeacher method in TeacherServiceImpl was accessed");
			Teacher res = teacherRepository.getReferenceById(id);
				return converter.convert(res, TeacherDto.class);
	}

	public void addTeacher(Teacher teacher) {
		logger.info("addTeacher method in TeacherServiceImpl was accessed");
		teacherRepository.save(teacher);
	}

	public void updateTeacher(Long id, Teacher teacher) {
		logger.info("updateTeacher method in TeacherServiceImpl was accessed");
		teacherRepository.save(teacher);
	}

	public void deleteTeacher(Long id) {
		logger.info("deleteTeacher method in TeacherServiceImpl was accessed");
		teacherRepository.deleteById(id);
	}
}
