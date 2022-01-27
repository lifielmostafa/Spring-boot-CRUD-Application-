package match.football.persistence;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import match.football.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	public Collection<Equipe> findByPays(String pays);
	
	
	
	public Equipe findByNomEquipe(String nomEquipe);

}
