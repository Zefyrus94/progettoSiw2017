package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import it.uniroma3.galleria.model.Ruolo;
import it.uniroma3.spring.service.RuoloService;
import it.uniroma3.spring.model.Ruolo;
import it.uniroma3.spring.model.User;
import it.uniroma3.spring.service.UserService;
//import it.uniroma3.spring.validator.UserValidator;


@Controller
public class UserController  {
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private UserService userservice; 
	private Ruolo ROLE_USER;
//    @Autowired
//    private UserValidator userValidator;
	@GetMapping("/user")
	public String showForm(User user) {
		return "form";
	}

	//mostra le info dell'utente
	@PostMapping("/user")
	public String checkUserInfo(@Valid @ModelAttribute User user, 
			BindingResult bindingResult, Model model) {
		System.out.println(user.getUsername());
		System.out.println(userservice.findByUsername(user.getUsername()));
		if (!bindingResult.hasErrors() && userservice.findByUsername(user.getUsername())==null) {
	        //userValidator.validate(user, bindingResult);
			//        	System.out.println("siamo qui");
			//        	User u= new User(user.getFirstName(), user.getLastName(), user.getAge());
			//        	System.out.println(u);
			//        	model.addAttribute(u);
			//            userservice.add(u); 
			System.out.println("siamo qui");
			System.out.println(user);
			System.out.println(userservice.findAll());
			Ruolo r= new Ruolo();
			r.setRuolo("ROLE_USER");
			r.setUsername(user.getUsername());
			user.setRuolo(r);
			model.addAttribute(user);
			System.out.println(user.getRuolo());
			//ruoloService.add(ROLE_USER);
			userservice.add(user);
			return "user/info";
		}
		/*bisona lanciare e catturare un'eccezione nonunique su username*/
//		if(userservice.findByUsername(user.getUsername())!=null){
////			Errors errors=;
////			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
//			return "form";
//		}
		else {
			return "form";
		}
		
	}
}
