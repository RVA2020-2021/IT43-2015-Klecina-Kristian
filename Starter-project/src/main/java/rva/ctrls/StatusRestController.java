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
import rva.jpa.Status;
import rva.repository.StatusRepository;


@CrossOrigin
@RestController
@Api(tags = {"Status CRUD operacije"})
public class StatusRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private StatusRepository statusRepository;
	
	
	@GetMapping("status")
	@ApiOperation(value = "Vraca statuse iz baze podataka")
	public Collection<Status> getStatusi() {
		return statusRepository.findAll();
	}
	
	@GetMapping("status/{id}")
	@ApiOperation(value = "Vraca jedan status iz baze podataka")
	public Status getStatus(@PathVariable("id") Integer id) {
		return statusRepository.getOne(id);
	}
	
	@GetMapping("statusNaziv/{naziv}")
	@ApiOperation(value = "Vraca status po nazivu iz baze podataka")
	public Collection<Status> getStatusByNaziv(@PathVariable("naziv") String naziv){
		return statusRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("status")
	@ApiOperation(value = "Upisuje jedan status u bazu podataka")
	public ResponseEntity<Status> insertStatus(@RequestBody Status status){
		if(!statusRepository.existsById(status.getId())) {
			statusRepository.save(status);
			return new ResponseEntity<Status>(HttpStatus.OK);
		}
		return new ResponseEntity<Status>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("status")
	@ApiOperation(value = "Azurira jedan status iz baze podataka")
	public ResponseEntity<Status> updateArtikl(@RequestBody Status status) {
		if (!statusRepository.existsById(status.getId())) {
			return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
		}
		statusRepository.save(status);
		return new ResponseEntity<Status>(HttpStatus.OK);
	}
	
	@DeleteMapping("status/{id}")
	@ApiOperation(value = "Brise jedan status iz baze podataka")
	public ResponseEntity<Status> deleteStatus(@PathVariable("id")Integer id){
		if(!statusRepository.existsById(id)) {
			return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
		}
		statusRepository.deleteById(id);
		
		
		
		if(id == -100) {
			jdbcTemplate.execute(
					"INSERT INTO \"status\"(\"id\",\"naziv\", \"oznaka\") "
					+ "VALUES (-100, 'TestStatus', 'TestOznaka')");
		}
		
		return new ResponseEntity<Status>(HttpStatus.OK);
	}
	
	
}
