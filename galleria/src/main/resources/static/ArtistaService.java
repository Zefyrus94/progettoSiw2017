package it.uniroma3.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.repository.ArtistaRepository;
@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository; 

	public Iterable<Artista> findAll() {
		return this.artistaRepository.findAll();
	}

	@Transactional
	public void add(final Artista Artista) {
		this.artistaRepository.save(Artista);
	}

	public Artista findbyId(Long id) {
		return this.artistaRepository.findOne(id);
	}

}

