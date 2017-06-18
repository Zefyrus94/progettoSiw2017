package it.uniroma3.spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//@NamedQuery(name="findAll", query="SELECT o FROM opera o")
public class Opera implements Comparable<Opera>{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;   
	@NotNull
	private String titolo;
	@NotNull
	private int anno;
	@NotNull
	private String tecnica;
	@NotNull
	private String dimensione;
	
    private String url;

//    @ManyToOne
//	private Stanza stanza;
//	
	@ManyToOne
	private Artista artista;
    
	//test postgres
    public Opera() {	
	}

	public Opera(Long id, String titolo, int anno, String tecnica, String dimensione, String url, Artista artista) {
		super();
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.dimensione = dimensione;
		this.url = url;
		this.artista = artista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
    
	@Override
	public String toString() {
		return String.format(
				"Opera[id=%d, titolo='%s', tecnica='%s', anno=%d]",
				id, titolo, tecnica, anno);
	}
	@Override
	public int compareTo(Opera that) {
		return this.titolo.toUpperCase().compareTo(that.titolo.toUpperCase());
	}
    
    
    //	@ManyToMany(mappedBy="opere")
//	private List <Artista> artista;
//	private Artista artista;
//	@OneToMany
//	private Amministratore amministratori;
//	@ManyToMany
//	private Percorso percorsi;

	

//	public Amministratore getAmministratore() {
//		return amministratori;
//	}
//	public void setAministratori(Amministratore amministratori) {
//		this.amministratori = amministratori;
//	}
//	public Percorso getPercorsi() {
//		return percorsi;
//	}
//	public void setPercorsi(Percorso percorsi) {
//		this.percorsi = percorsi;
//	}

	
	
}
