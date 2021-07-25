package it.uniroma3.galleria.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository; 

	@Transactional
	public void addArtista(final Artista Artista) {
		this.artistaRepository.save(Artista);
	}
	
	@Transactional
	public void delete(Artista artist){
		this.artistaRepository.delete(artist);
	}
	@Transactional
	public void deleteById(long id){
		this.artistaRepository.deleteById(id);
	}
	@Transactional
	public void removeArtista(Artista Artista){
		this.artistaRepository.delete(Artista);
	}
	
	public Iterable<Artista> findAll() {
		return this.artistaRepository.findAll();
	}
	public Artista findbyId(Long id) {
		return this.artistaRepository.findById(id).get();
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