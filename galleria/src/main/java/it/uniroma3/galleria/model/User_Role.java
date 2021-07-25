package it.uniroma3.galleria.model;

import javax.persistence.*;

@Entity
@Table(name = "ruoli_utente", uniqueConstraints = {@UniqueConstraint(columnNames = {"utente_id", "ruolo"})})
public class User_Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ruolo_utente_id")
	private Integer ruoloUtenteId;
	
	@OneToOne
	private User utente;
	
	private String ruolo;
	
	public User_Role(User utente, String ruolo){
		this.utente = utente;
		this.ruolo = ruolo;
	}

	public Integer getRuoloUtenteId() {
		return ruoloUtenteId;
	}

	public void setRuoloUtenteId(Integer ruoloUtenteId) {
		this.ruoloUtenteId = ruoloUtenteId;
	}

	public User getUtente() {
		return utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}	
}
