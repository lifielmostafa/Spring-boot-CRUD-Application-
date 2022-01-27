package match.football.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import match.football.entities.Arbitre;
import match.football.persistence.ArbitreRepository;
@Service
public class ArbitreService {
	@Autowired
	ArbitreRepository arbitrerepository;
	public Collection<Arbitre> GetAllArbitre(){
		return arbitrerepository.findAll();
	}
    public Arbitre GetArbitre(Long id) {
    	return arbitrerepository.findById(id).get();
		
	}
	public Arbitre AddArbitrre(Arbitre a) {
		return  arbitrerepository.save(a);
	}
	
	public void DeleteArbitre(Long id) {
		arbitrerepository.deleteById(id);
	}
	
	public ResponseEntity<Arbitre> updatearbitre( Long id,Arbitre a){
	Arbitre arbitre =arbitrerepository.getOne(id);
	arbitre.setNom(a.getNom()); 
	arbitre.setNationalite(a.getNationalite());
	arbitre.setMatchs(a.getMatchs());
	Arbitre   updatearbitre =arbitrerepository.save(arbitre);
		return ResponseEntity.ok( updatearbitre);
	}

}
