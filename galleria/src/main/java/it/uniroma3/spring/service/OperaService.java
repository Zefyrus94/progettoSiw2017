package it.uniroma3.spring.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.model.Opera;

import it.uniroma3.spring.repository.OperaRepository;

@Service
public class OperaService {
    
	@Autowired
    
	EntityManager em;
    
    @Autowired
    private OperaRepository operaRepository; 
 

    public Iterable<Opera> findAll() {
        return this.operaRepository.findAll();
    }
    @Transactional
	public void delete(Long id){
		this.operaRepository.delete(id);
	}
    
	public Opera save(Opera entity) {
		if (!em.contains(entity)) {
			em.persist(entity);
			return entity;
		} else {
			return em.merge(entity);
		}
	}
    
    @Transactional
    public void add(final Opera opera) {
        this.operaRepository.save(opera);
    }

	public Opera findbyId(Long id) {
		return this.operaRepository.findOne(id);
	}
	public List<Opera> findByAutore(Artista autore){
		return this.operaRepository.findByAutore(autore);
	}
	
}
