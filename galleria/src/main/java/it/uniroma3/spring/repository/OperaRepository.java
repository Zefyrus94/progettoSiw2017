package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long> {

    List<Opera> findByNome(String nome);
    
    List<Opera> findByAnno(Integer anno);
   
	List<Opera> findByAutore(Artista autore);


	
    
}