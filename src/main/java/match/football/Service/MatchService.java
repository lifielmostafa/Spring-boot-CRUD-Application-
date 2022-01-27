package match.football.Service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import match.football.entities.Matchh;
import match.football.persistence.MatchRepository;
@Service
public class MatchService {
	@Autowired
	MatchRepository matchrepository;
	
	public Collection<Matchh> getAllMatch() {
		return matchrepository.findAll();
	}
	public Matchh getMatch(Long id) {
		return matchrepository.findById(id).get();
	}
	public Matchh  addMatch(Matchh m) {
		return matchrepository.save(m);
	}
	public void deleteMatch(Long id) {
		matchrepository.deleteById(id);
	}
	public ResponseEntity<Matchh> updatematch(Long id, Matchh m){
		Matchh matchh = matchrepository.getOne(id); 
		matchh.setDateMatch(m.getDateMatch());
		matchh.setHeureMatch(m.getHeureMatch());
		matchh.setArbitre(m.getArbitre());
		matchh.setStade(m.getStade());
		matchh.setEquipes(m.getEquipes());
		Matchh updatematch =matchrepository.save(matchh);
		return ResponseEntity.ok(updatematch);
	}
	
	public Collection<Matchh> findMatcheByDate(Date datematch){
		return matchrepository.findByDateMatch(datematch);
	}
	public Collection<Matchh> removeByDateMatchLessThan(Date dateCurrent){
		return matchrepository.removeByDateMatchLessThan(dateCurrent);
	}
	}

