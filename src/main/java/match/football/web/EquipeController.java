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

import match.football.Service.EquipeService;
import match.football.entities.Equipe;
import match.football.entities.Joueur;
@RestController
public class EquipeController {
	@Autowired
	EquipeService equipeservice;
	
	@GetMapping("/equipe")
	public Collection<Equipe> getAllequipe() {
		return equipeservice.GetAllEquipe();}
	
	@GetMapping("/equipe/{id}")
	public Equipe getEquipe(@PathVariable Long id ) {
		return equipeservice.GetEquipe(id);
	}
	
	
	@PostMapping("/equipe")
	public Equipe addEquipe(@RequestBody Equipe a) {
		return equipeservice.AddEquipe(a);
	}
	
	@PutMapping("/equipe/{id}")
	public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe a) {
		return equipeservice.updateequipe(id, a);
	}
	
	@DeleteMapping("/equipe/{id}")
	public void deleteEquipe(@PathVariable Long id) {
		equipeservice.DeleteEquipe(id);;
	}
	@GetMapping("/payes/{pays}")
	public Collection<Equipe> getpays(@PathVariable String pays) {
		return equipeservice.getByPays(pays);
	}
	@GetMapping("joueurequipe/{name}")
	public Collection<Joueur> getjoueurequipe(@PathVariable String name)
	{return equipeservice.findByNomEquipe(name).getJoueurs(); }
	@GetMapping("/equipe/{poste}/{equipe}")
	public Collection<Joueur> findByNomEq(@PathVariable String poste,@PathVariable String equipe ) {
		Collection<Joueur> Joueur = equipeservice.findByNomEquipe(equipe).getJoueurs();
		System.out.println(poste);
		Joueur.removeIf(i -> (!i.getPoste().equals(poste)));
		return Joueur;
	}
}

