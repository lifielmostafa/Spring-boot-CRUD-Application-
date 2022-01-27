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
import match.football.Service.JoueurService;
import match.football.entities.Joueur;
@RestController
public class JoueurController {
	@Autowired
	 JoueurService joueurservice;
	
	@GetMapping("/joueur")
	public Collection<Joueur> getAllJoueur() {
		return joueurservice.GetAllJoueur();
	}
	@GetMapping("/joueur/{id}")
	public Joueur getJoueur(@PathVariable Long id ) {
		return joueurservice.GetJoueur(id);	}
	
	
	@PostMapping("/joueur")
	public Joueur addJoueur(@RequestBody Joueur  j) {
		return joueurservice.AddJoueur(j);
	}
	
	@PutMapping("/joueur/{id}")
	public ResponseEntity<Joueur> updatejoueur(@PathVariable Long id, @RequestBody Joueur j) {
		return joueurservice.updatejoueur(id, j);
	}
	
	@DeleteMapping("/joueur/{id}")
	public void deleteJoueur(@PathVariable Long id) {
		joueurservice.DeleteJoueur(id);
	}
    
}
