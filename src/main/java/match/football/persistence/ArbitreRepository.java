package match.football.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import match.football.entities.Arbitre;

public interface ArbitreRepository extends JpaRepository<Arbitre, Long>{
}
