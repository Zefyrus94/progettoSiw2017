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
	EntityManager em;

	    @Autowired
	    private OperaRepository operaRepository; 

	    public Iterable<Opera> findAll() {
	        return this.operaRepository.findAll();
	    }
	    public List<Opera> findByAutore(Artista artista){
			return this.operaRepository.findByArtista(artista);
		}

		public Opera findbyId(Long id) {
			return this.operaRepository.findOne(id);
		}
	    
	    @Transactional
		public void delete(Long id){
			this.operaRepository.delete(id);
		}
	    @Transactional
	    public void add(final Opera Opera) {
	        this.operaRepository.save(Opera);
	    }
	    
		public Opera save(Opera entity) {
			if (!em.contains(entity)) {
				em.persist(entity);
				return entity;
			} else {
				return em.merge(entity);
			}
		}
		
	}
