package match.football.web;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import match.football.Service.MatchService;
import match.football.entities.Equipe;
import match.football.entities.Matchh;
import match.football.entities.Stade;

@RestController
public class MatchController {
	@Autowired
	MatchService matchservice;
	
	@GetMapping("/matchh")
	public Collection<Matchh> getAllMatch() {
		return matchservice.getAllMatch();}
	@GetMapping("/matchh/{id}")
	public Matchh getMatch(@PathVariable Long id ) {
		return matchservice.getMatch(id)	;}
	
	@PostMapping("/matchh")
	public Matchh addMatch(@RequestBody Matchh m) {
		return matchservice.addMatch(m);
	}
	
	@PutMapping("/matchh/{id}")
	public ResponseEntity<Matchh> updatematch(@PathVariable Long id, @RequestBody Matchh m) {
		return matchservice.updatematch(id, m);
	}
	
	@DeleteMapping("/matchh/{id}")
	public void deleteMatch(@PathVariable Long id) {
		matchservice.deleteMatch(id);
	}
	@GetMapping("/matchhdate")
	public Collection<Matchh> getMatchBydate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return matchservice.findMatcheByDate(date);
	}
	@GetMapping("/matchstade/{id}")
	public Stade getmatchstade(@PathVariable Long id ) {
		return matchservice.getMatch(id).getStade();}
	@GetMapping("/equipematch/{id}")
	public Collection<Equipe> getequipematch(@PathVariable Long id ) {
		return matchservice.getMatch(id).getEquipes();}
	@DeleteMapping("/matchpasse")
	public Collection<Matchh> removeByDateMatchLessThan(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateCurrent)
	{return matchservice.removeByDateMatchLessThan(dateCurrent);}
		
	
}
