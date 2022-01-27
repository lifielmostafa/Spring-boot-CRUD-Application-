package match.football.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import match.football.entities.Stade;

public interface StadeRepository extends JpaRepository<Stade, Long> {

}
