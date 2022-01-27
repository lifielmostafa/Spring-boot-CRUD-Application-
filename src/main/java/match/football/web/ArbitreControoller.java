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

import match.football.Service.ArbitreService;
import match.football.entities.Arbitre;

@RestController
public class ArbitreControoller {
	@Autowired
	ArbitreService arbitreservice;
	
	@GetMapping("/arbitre")
	public Collection<Arbitre> getAllarb() {
		return arbitreservice.GetAllArbitre();
	}
	@GetMapping("/arbitre/{id}")
	public Arbitre getArbbyid(@PathVariable Long id ) {
		return arbitreservice.GetArbitre(id);
	}
	
	
	@PostMapping("/arbitre")
	public Arbitre addArbitre(@RequestBody Arbitre a) {
		return arbitreservice.AddArbitrre(a);
	}
	
	@PutMapping("/arbitre/{id}")
	public ResponseEntity<Arbitre> updateArbitre(@PathVariable Long id, @RequestBody Arbitre a) {
		return arbitreservice.updatearbitre(id, a);
	}
	
	@DeleteMapping("/arbitre/{id}")
	public void deleteArbitre(@PathVariable Long id) {
		arbitreservice.DeleteArbitre(id);;
	}
}
