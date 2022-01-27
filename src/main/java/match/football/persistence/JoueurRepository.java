package match.football.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import match.football.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}
