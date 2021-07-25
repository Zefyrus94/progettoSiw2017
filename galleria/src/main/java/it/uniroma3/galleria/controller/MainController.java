package it.uniroma3.galleria.controller;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.galleria.model.User;
import it.uniroma3.galleria.service.UserService;



@Controller
@SessionAttributes("current_username")
public class MainController {

	@Autowired
	private UserService utenteService;
	//	@Autowired
	//	private GaraService garaService;

	@GetMapping(value={"/user/home","/home","/utente", "/admin"})
	public String homepage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			User utente = utenteService.findByUsername(authentication.getName());
			model.addAttribute(utente);
			model.addAttribute("current_username", utente.getUsername());
		}
		return "index";
	}

	@RequestMapping("/accedi_admin")
	public String accedia(@Valid @ModelAttribute User utente, Model model) {
		return "accessoadmin";
	}
	@RequestMapping("/quotes")
	public String citazioni(@Valid @ModelAttribute User utente, Model model) {
		return "citazioni";
	}
	@RequestMapping("/contacts")
	public String contatti(@Valid @ModelAttribute User utente, Model model) {
		return "contacts";
	}
	@RequestMapping("/news")
	public String news(@Valid @ModelAttribute User utente, Model model) {
		return "news";
	}
}
