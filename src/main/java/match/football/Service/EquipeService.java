package match.football.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import match.football.entities.Equipe;
import match.football.persistence.EquipeRepository;
@Service
public class EquipeService {

	@Autowired
	EquipeRepository equiperepository;
	public Collection<Equipe> GetAllEquipe(){
		return equiperepository.findAll();
	}
    public Equipe GetEquipe(Long id) {
    	return equiperepository.findById(id).get();
		
	}
	public Equipe AddEquipe(Equipe e) {
		return  equiperepository.save(e);
	}
	
	public void DeleteEquipe(Long id) {
		equiperepository.deleteById(id);
	}
	
	public ResponseEntity<Equipe> updateequipe( Long id,Equipe e){
	Equipe equipe =equiperepository.getOne(id);
	equipe.setNomEquipe(e.getNomEquipe());
	equipe.setPays(e.getPays());
	equipe.setJoueurs(e.getJoueurs());
	equipe.setMatches(e.getMatches());
	Equipe   updateequipe =equiperepository.save(equipe);
	return ResponseEntity.ok(updateequipe);
	}
	
	public Collection<Equipe> getByPays(String pays) {
		return equiperepository.findByPays(pays);}
	
	public Equipe findByNomEquipe(String name) {
		return equiperepository.findByNomEquipe(name);
	}
	
}
      