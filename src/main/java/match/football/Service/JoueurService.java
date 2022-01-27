package match.football.Service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import match.football.entities.Joueur;
import match.football.persistence.JoueurRepository;
@Service
public class JoueurService {
	@Autowired
	JoueurRepository joueurrepository;
	public Collection<Joueur> GetAllJoueur(){
		return joueurrepository.findAll();
	}
    public Joueur GetJoueur(Long id) {
    	return joueurrepository.findById(id).get();
		
	}
	public Joueur AddJoueur(Joueur j) {
		return  joueurrepository.save(j);
	}
	
	public void DeleteJoueur(Long id) {
		joueurrepository.deleteById(id);
	}
	
	public ResponseEntity<Joueur> updatejoueur( Long id,Joueur j){
	Joueur joueur =joueurrepository.getOne(id);
	joueur.setNom(j.getNom());
	joueur.setPoste(j.getPoste());
	joueur.setEquipes(j.getEquipes());
	Joueur   updatejoueur =joueurrepository.save(joueur);
	return ResponseEntity.ok(updatejoueur);
	}
}
