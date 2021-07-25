package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.User;
import it.uniroma3.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }
	public boolean alreadyExists(String username) {
		return (this.userRepository.findByUsername(username)!=null);	
	}
    @Transactional
    public void save(final User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	user.setEnabled(true);
        this.userRepository.save(user);
    }

	public User findbyId(Long id) {
		return this.userRepository.findOne(id);
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

}
