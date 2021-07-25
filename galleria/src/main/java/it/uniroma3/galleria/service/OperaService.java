package it.uniroma3.galleria.service;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.repository.OperaRepository;
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
			//return this.operaRepository.findOne(id);
			return this.operaRepository.findById(id).get();
		}
	    
	    @Transactional
		public void delete(Opera opera){
			this.operaRepository.delete(opera);
		}
		@Transactional
		public void deleteById(long id){
			this.operaRepository.deleteById(id);
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
