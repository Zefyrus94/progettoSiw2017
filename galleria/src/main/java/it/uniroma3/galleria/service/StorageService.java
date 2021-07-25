package it.uniroma3.galleria.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.repository.OperaRepository;
 
 
@Service
public class StorageService {
	EntityManager em;

    @Autowired
    private OperaRepository operaRepository; 

    public Iterable<Opera> findAll() {
        return this.operaRepository.findAll();
    }
    public Opera findbyId(Long id) {
		return this.operaRepository.findById(id).get();
	}
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");
 
	public void store(MultipartFile file){
		try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!");
        }
	}
 
    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
        	throw new RuntimeException("FAIL!");
        }
    }
    
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
 
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}