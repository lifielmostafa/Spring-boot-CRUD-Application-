package match.football.entities;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 Long idEquipe;
	@Column
 String nomEquipe;
	@Column
 String pays;
	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY,mappedBy = "equipes")
	@JsonManagedReference
	Collection<Joueur> joueurs;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "equipes")
	@JsonIgnore
	Collection<Matchh> matches;
	public Equipe() {}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Collection<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(Collection<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	public Collection<Matchh> getMatches() {
		return matches;
	}
	public void setMatches(Collection<Matchh> matches) {
		this.matches = matches;
	}
	


}
