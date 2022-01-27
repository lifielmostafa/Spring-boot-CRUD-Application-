package match.football.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Arbitre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idArbitre;
	@Column
	String nom;
	@Column
	String nationalite;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "arbitre")
	Collection<Matchh> matchs;
	public Arbitre() {}
	public Long getIdArbitre() {
		return idArbitre;
	}
	public void setIdArbitre(Long idArbitre) {
		this.idArbitre = idArbitre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public Collection<Matchh> getMatchs() {
		return matchs;
	}
	public void setMatchs(Collection<Matchh> matchs) {
		this.matchs = matchs;
	}
	
	
}
