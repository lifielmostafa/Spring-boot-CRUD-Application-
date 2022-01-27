package match.football.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
Long idJoueur;
	@Column
String nom;
	@Column
String poste;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	Equipe equipes;
	public Joueur() {}
	public Long getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Equipe getEquipes() {
		return equipes;
	}
	public void setEquipes(Equipe equipes) {
		this.equipes = equipes;
	}
	
}
