package it.uniroma3.spring.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opera implements Comparable<Opera> {

protected Opera() {}
	
	public Opera(String nome, String descrizione,String tecnica, Integer anno, Artista autore/*, Stanza stanza*/, String urlImmagine,double lunghezza,double larghezza) {
		this.nome = nome;
		
		this.descrizione = descrizione;
		this.anno = anno;
		this.autore =autore;
		//this.stanza=stanza;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;

	@NotNull
	@Size(min=1)
	private String descrizione;

	@NotNull
	@Min(1)
	private Integer anno;
	
//	@ManyToOne
//	private Stanza stanza;
//	
	@ManyToOne
	private Artista autore;

	public Artista getAutore() {
		return autore;
	}

	public void setAutore(Artista autore) {
		this.autore = autore;
	}

//	public Stanza getStanza() {
//		return stanza;
//	}
//
//	public void setStanza(Stanza stanza) {
//		this.stanza = stanza;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {
		return String.format(
				"Opera[id=%d, nome='%s', descrizione='%s', anno=%d]",
				id, nome, descrizione, anno);
	}
	@Override
	public int compareTo(Opera that) {
		return this.nome.toUpperCase().compareTo(that.nome.toUpperCase());
	}
}