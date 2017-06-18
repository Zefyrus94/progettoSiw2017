package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.spring.service.RuoloService;
//import it.uniroma3.spring.model.Ruolo;
import it.uniroma3.spring.model.User;
//import it.uniroma3.spring.service.RuoloService;
import it.uniroma3.spring.service.UserService;

// controller to access the login page
@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private RuoloService ruoloService;
//	@Autowired
//	private RuoloService ruoloService;
	@GetMapping("/signUp")
	public String signUp(Model model){
		model.addAttribute("user",new User());
		return "form";
	}
//	@RequestMapping(value="/signUp", method=RequestMethod.POST)
//	public String contactSubmit(@ModelAttribute User user, BindingResult bindingResult, Model model) {
//	    if (bindingResult.hasErrors()) {
//	        //errors processing
//	    	return "signUp";
//	    }  
//	    model.addAttribute("user", user);
//	    userService.add(user);
//	    return "user/info";
//	}
	// Login form
    @PostMapping("/login")
    public String checkUserInfo(@Valid @ModelAttribute User user, 
    									BindingResult bindingResult, Model model) {
    	//return "home";
    	if(bindingResult.hasErrors()){ model.addAttribute("loginError", true); return "login";}
    	Long id= user.getId();
    	System.out.print(id);
    	System.out.print("tentativo di autenticazione");
		User c= userService.findbyId(id);		
        if(c!=null && c.getRuolo()!=null) {System.out.println("ruolo:" + c.getRuolo());return "home";}//se esiste un utente con quell'id allora puoi entrare nell'area riservata
        return "home";
    }
//	@RequestMapping("/login")
//	public String login() {
//		return "login";
//	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	// Login form with error
//	@RequestMapping("/login-error.html")
//	public String loginError(Model model) {
//		model.addAttribute("loginError", true);
//		return "login";
//	}
	@RequestMapping(value="/admin")
	public String admin(){
		return "admin";
	}
	@RequestMapping(value="/home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/signup")
	public String registrati() {
		return "form";
	}
}