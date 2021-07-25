package it.uniroma3.galleria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.User_Role;
import it.uniroma3.galleria.repository.User_Role_Repository;

@Service
public class User_Role_Service {
	
	@Autowired
	private User_Role_Repository ruoloUtenteRepository;
	
	@Transactional
	public void add(final User_Role ruoloUtente) {
		this.ruoloUtenteRepository.save(ruoloUtente);
	}
}