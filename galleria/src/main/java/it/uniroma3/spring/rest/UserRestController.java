//package it.uniroma3.spring.rest;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.uniroma3.spring.model.User;
//import it.uniroma3.spring.service.UserService;
//
//@RestController
//public class UserRestController {
//
//		@Autowired
//		UserService UserService;
//		
//	    @RequestMapping("/rest/user/{id}")
//	    public User getUser(@PathVariable Long id) {
//	        return UserService.findbyId(id);
//	    }
//	}