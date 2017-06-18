package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Image;


public interface ImageRepository  extends CrudRepository<Image, Long>{

	
	List<Image> findByImage(Integer imageID);
}