package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String lastName);
    
    List<User> findByAge(Integer age);
    
    User findByUsername(String username);
    
}