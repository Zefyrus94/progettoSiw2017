package it.uniroma3.spring.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Artista;



public interface ArtistaRepository extends CrudRepository<Artista, Long> {

	List<Artista> findAll();
	
    List<Artista> findByNome(String nome);
    
    List<Artista> findByCognome(String cognome);
    
    List<Artista> findByNazionalita(String nazionalita);
    
    List<Artista> findByAnnoNascita(Date annoNascita);
    
    List<Artista> findByAnnoMorte(Date annoMorte);
 
}
