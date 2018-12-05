package com.qien.sqraper.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qien.sqraper.domain.Student;
import com.qien.sqraper.domain.Vacature;

@Service
@Transactional
public class SqraperService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) { // voor put and post
		return studentRepository.save(student);
	}

	public Student findStudentById(Long id) { // voor get by ID
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			return null;
		}
	}

	public Iterable<Student> findAllStudents() { // voor get all
		return studentRepository.findAll();
	}

	public void deleteStudentById(Long id) { // voor delete
		if (studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
		}
	}
// ==========================================================================	
//	VACATURE GEDEELTE
	
	@Autowired
	private VacatureRepository vacatureRepository;
	
	public Vacature save(Vacature vacature) { // voor put and post
		return vacatureRepository.save(vacature);
	}

	public Vacature findById(Long id) { // voor get
		Optional<Vacature> vacature = vacatureRepository.findById(id);
		if (vacature.isPresent()) {
			return vacature.get();
		} else {
			return null;
		}
	}

	public Iterable<Vacature> findAll() {
		return vacatureRepository.findAll();
	}

	public void deleteById(Long id) { // voor delete
		if (vacatureRepository.findById(id).isPresent()) {
			vacatureRepository.deleteById(id);
		}

	}

}
