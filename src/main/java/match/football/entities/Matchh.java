package match.football.entities;



import java.time.LocalDate;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Matchh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idMatch;
	@Column
	@Temporal(TemporalType.DATE)
	Date dateMatch;
	@Column
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss")
	Date heureMatch;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
	Arbitre arbitre;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	Stade stade;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "matches_equipes", 
    joinColumns = @JoinColumn(name = "matche_id", referencedColumnName = "idMatch"), 
	inverseJoinColumns = @JoinColumn(name = "equipe_id", 
	referencedColumnName = "idEquipe"))
	Collection<Equipe> equipes;
	public Matchh() {}
	public Long getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(Long idMatch) {
		this.idMatch = idMatch;
	}
	public Date getDateMatch() {
		return dateMatch;
	}
	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}
	public Date getHeureMatch() {
		return heureMatch;
	}
	public void setHeureMatch(Date heureMatch) {
		this.heureMatch = heureMatch;
	}
	public Arbitre getArbitre() {
		return arbitre;
	}
	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}
	public Stade getStade() {
		return stade;
	}
	public void setStade(Stade stade) {
		this.stade = stade;
	}
	public Collection<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	
}
