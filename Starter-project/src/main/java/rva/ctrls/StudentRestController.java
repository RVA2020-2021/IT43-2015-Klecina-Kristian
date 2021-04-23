package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.repository.DepartmanRepository;
import rva.repository.StatusRepository;
import rva.repository.StudentRepository;
import rva.jpa.Departman;
import rva.jpa.Status;
import rva.jpa.Student;


@CrossOrigin
@RestController
@Api(tags = {"Student CRUD operacije"})

public class StudentRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private DepartmanRepository departmanRepository;
	
	@GetMapping("student")
	@ApiOperation(value = "Vraca sve studente iz baze podataka")
	public Collection<Student> getStudenti(){
		return studentRepository.findAll();
	}

	@GetMapping("student/{id}")
	@ApiOperation(value = "Vraca jednog studenta iz baze podataka")
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentRepository.getOne(id);
	}
	
	@GetMapping("studentBrojIndeksa/{brojIndeksa}")
	@ApiOperation(value = "Vraca studenta po broju indeksa iz baze podataka")
	public Collection<Student> getStudentByBrojIndeksa(@PathVariable("brojIndeksa") String brojIndeksa){
		return studentRepository.findByBrojIndeksaContainingIgnoreCase(brojIndeksa);
	}
	
	@GetMapping("studentStatus/{id}")
	@ApiOperation(value = "Vraca studente po statusu iz baze podataka")
	public Collection <Student> studentPoStatusId(@PathVariable("id") Integer id){
		Status s = statusRepository.getOne(id);
		return studentRepository.findByStatus(s);
	}
	
	@GetMapping("studentDepartman/{id}")
	@ApiOperation(value = "Vraca studente po departmanu iz baze podataka")
	public Collection<Student> studentiPoDepartmanId(@PathVariable("id") Integer id){
		Departman d = departmanRepository.getOne(id);
		return studentRepository.findByDepartman(d);
	}
	
	
	@PostMapping("student")
	@ApiOperation(value = "Upisuje jednog studenta iz baze podataka")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student){
		if(!studentRepository.existsById(student.getId())) {
			studentRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("student")
	@ApiOperation(value = "Azurira jednog studenta iz baze podataka")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		if(!studentRepository.existsById(student.getId())) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		studentRepository.save(student);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	@DeleteMapping("student/{id}")
	@ApiOperation(value = "Brise jednog studenta iz baze podataka")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id")Integer id){
		if(!studentRepository.existsById(id)) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		studentRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute(
					"INSERT INTO \"student\"(\"id\",\"ime\",\"prezime\",\"broj_indeksa\",\"status\",\"departman\") "
							+ "VALUES (-100, 'TestIme', 'TestPrezime', 'TestBrIndx', 1, 1)"
					);
		}
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
}
