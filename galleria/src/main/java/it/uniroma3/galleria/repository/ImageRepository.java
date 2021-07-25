package it.uniroma3.galleria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Image;


public interface ImageRepository  extends CrudRepository<Image, Long>{

	
	List<Image> findByImage(Integer imageID);
}