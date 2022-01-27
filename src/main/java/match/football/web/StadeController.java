package match.football.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import match.football.Service.StadeService;
import match.football.entities.Stade;
@RestController
public class StadeController {
	@Autowired
	StadeService stadeservice;
	
	@GetMapping("/stade")
	public Collection<Stade> getAllStade() {
		return stadeservice.GetAllStade();
	}
	@GetMapping("/stade/{id}")
	public Stade getstade(@PathVariable Long id ) {
		return stadeservice.GetStade(id);}
	
	
	@PostMapping("/stade")
	public Stade addStade(@RequestBody Stade s) {
		return stadeservice.AddsStade(s);
	}
	
	@PutMapping("/stade/{id}")
	public ResponseEntity<Stade> updateStade(@PathVariable Long id, @RequestBody Stade s) {
		return stadeservice.updateStade(id, s);
	}
	
	@DeleteMapping("/stade/{id}")
	public void deleteSatde(@PathVariable Long id) {
		stadeservice.DeleteStade(id);
	}
}
