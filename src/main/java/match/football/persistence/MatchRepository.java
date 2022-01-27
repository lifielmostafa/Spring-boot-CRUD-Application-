package match.football.persistence;

import java.util.Collection;
import java.util.Date;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import match.football.entities.Matchh;

public interface MatchRepository extends JpaRepository<Matchh, Long> {
	public Collection<Matchh> findByDateMatch(Date dateMatch);
	@Transactional
	public Collection<Matchh> removeByDateMatchLessThan(Date dateCurrent);
}
