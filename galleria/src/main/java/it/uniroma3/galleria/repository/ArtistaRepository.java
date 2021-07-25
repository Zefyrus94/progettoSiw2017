package it.uniroma3.galleria.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Artista;



public interface ArtistaRepository extends CrudRepository<Artista, Long> {

	List<Artista> findAll();
	
    List<Artista> findByNome(String nome);
    
    List<Artista> findByCognome(String cognome);
    
    List<Artista> findByNazionalita(String nazionalita);
    
    List<Artista> findByAnnoNascita(Date annoNascita);
    
    List<Artista> findByAnnoMorte(Date annoMorte);
 
}
