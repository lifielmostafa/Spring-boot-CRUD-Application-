package match.football.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import match.football.entities.Stade;
import match.football.persistence.StadeRepository;
@Service
public class StadeService {
	@Autowired
    StadeRepository staderepository;
	public Collection<Stade> GetAllStade(){
		return staderepository.findAll();
	}
    public Stade GetStade(Long id) {
    	return staderepository.findById(id).get();
		
	}
	public Stade AddsStade(Stade s) {
		return  staderepository.save(s);
	}
	
	public void DeleteStade(Long id) {
		staderepository.deleteById(id);
	}
	
	public ResponseEntity<Stade> updateStade( Long id,Stade s){
		Stade stade =staderepository.getOne(id);
		stade.setNomStade(s.getNomStade());
		stade.setVille(s.getVille());
		stade.setMatchs(s.getMatchs());
	
	Stade   updateStade =staderepository.save(stade);
	return ResponseEntity.ok(updateStade);
	}
}
