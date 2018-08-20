package com.demo.kaderneta.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kaderneta.model.Discipline;
import com.demo.kaderneta.model.Notes;
import com.demo.kaderneta.model.Student;
import com.demo.kaderneta.model.StudentDTO;
import com.demo.kaderneta.repository.StudentDTORepository;
import com.demo.kaderneta.repository.StudentRespository;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentRespository studentRepository;

	@Autowired
	private StudentDTORepository studentDTORepository;

	@GetMapping
	public List<Student> listAll(Student student) {
		// Example<Student> example = Example.of(student);
		return studentRepository.findAll();
	}

	@GetMapping(path = "/filter")
	public List<Student> filterBy(@RequestParam String name) {
		return studentRepository.findByName(name);
	}

	@GetMapping(path = "/{id}")
	public Optional<Student> get(@PathVariable("id") Long id) {
		return studentRepository.findById(id);
	}

	@PostMapping(path = "/add-students")
	public Student save(@RequestBody Student student) {
		StudentDTO studentDTO = new StudentDTO();

		studentDTO.setActive(student.isActive());
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		studentDTO.setClasses(student.getClasses());
		studentDTO.setPendencies(student.getPendencies());

		studentDTORepository.save(studentDTO);
		return studentRepository.save(student);
	}

	@PutMapping(path = "/{id}")
	public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
		Student studentNew = studentRepository.getOne(id);
		StudentDTO studentDTO = studentDTORepository.getOne(id);

		if (studentNew == null) {
			throw new RuntimeException("Estudante inválido: " + id);
		}

		/**
		 * Inserir edição apenas dos dados modificados.
		 */
		studentNew.setActive(student.isActive());
		studentDTO.setActive(student.isActive());

		studentDTORepository.save(studentDTO);
		return studentRepository.save(studentNew);
	}

	@GetMapping("/{student_id)}/disciplines/{discipline_id}")
	public List<Notes> notes(@PathVariable("student_id") Long stud_id, @PathVariable("discipline_id") Long disc_id) {
		Student st = studentRepository.getOne(stud_id);

		List<Discipline> d = st.getDiscipline();
		List<Notes> note = null;
		for (Discipline discipline : d) {
			note = discipline.getNotes();
		}
		return note;
	}

	@PutMapping("/{id}/add-discipline")
	public Student addDiscipline(@PathVariable("id") Long id, @RequestBody Discipline discipline) {
		Student student = studentRepository.getOne(id);

		if (student == null) {
			throw new RuntimeException("Estudante inválido: " + id);
		}

		student.getDiscipline().add(discipline);
		return studentRepository.save(student);
	}
}
