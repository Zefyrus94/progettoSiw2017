package it.uniroma3.spring.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository; 

	@Transactional
	public void addArtista(final Artista Artista) {
		this.artistaRepository.save(Artista);
	}
	
	@Transactional
	public void delete(Long id){
		this.artistaRepository.delete(id);
	}
	@Transactional
	public void removeArtista(Artista Artista){
		this.artistaRepository.delete(Artista);
	}
	
	public Iterable<Artista> findAll() {
		return this.artistaRepository.findAll();
	}
	public Artista findbyId(Long id) {
		return this.artistaRepository.findOne(id);
	}
	
	public Iterable<Artista>findByNome(String titolo) {
		return this.artistaRepository.findByNome(titolo);
	}
	
	public Iterable<Artista>findByCognome(String cognome) {
		return this.artistaRepository.findByCognome(cognome);
	}
	
	public Iterable<Artista>findByNazionalita(String nazionalita) {
		return this.artistaRepository.findByNazionalita(nazionalita);
	}
	
	public Iterable<Artista>findByAnnoNascita(Date anno) {
		return this.artistaRepository.findByAnnoNascita(anno);
	}
	
	public Iterable<Artista>findByAnnoMorte(Date anno) {
		return this.artistaRepository.findByAnnoMorte(anno);
	}

}