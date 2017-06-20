package it.uniroma3.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.model.User;
import it.uniroma3.spring.service.ArtistaService;
import it.uniroma3.spring.service.OperaService;

@Controller
public class ArtistaController {
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	} 
		//github dà problemi
	
	@Autowired
	ArtistaService artistaService;
	@Autowired
	OperaService operaService;
	/*gli artisti vengono ordinati*/
	@GetMapping("/user/artisti")
	public String showartisti(@ModelAttribute User user,Model model){
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		Collections.sort(artisti);
		System.out.println(user);
		model.addAttribute(user);
		model.addAttribute("artisti", artisti);
		return "artista/artisti";
	}
	@GetMapping("/admin/artisti")
	public String showartistiAdm(@ModelAttribute User user,Model model){
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		Collections.sort(artisti);
		System.out.println(user);
		model.addAttribute(user);
		model.addAttribute("artisti", artisti);
		return "artista/adminArtisti";
	}
	@GetMapping("/artisti/anno")
	public String showartistiordered(@ModelAttribute User user,Model model){
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		Collections.sort(artisti, new CompAnno());
		model.addAttribute(user);
		model.addAttribute("artisti", artisti);
		return "artista/artisti";
	}
	
    @GetMapping("/admin/artista")
    public String showForm(Artista artista) {
        return "artista/formartista";
    }
    @GetMapping("/user/artista/resultsartista")
	public String showartista(@RequestParam("id")long id, Model model){
		Artista a = artistaService.findbyId(id);
		model.addAttribute("artista", a);
		return "artista/resultsartista";
	}
    

    @GetMapping("/admin/artista/cancella")
	public ModelAndView deleteartista(@RequestParam("id")long id, Model model){
		artistaService.delete(id);
		return new ModelAndView("redirect:/artisti");
		}
    @GetMapping("artista/Home")
	public String returnHome(){
		return "home/home";
	}
    
    @PostMapping("/admin/artistainfo")
    public String checkCustomerInfo(@Valid @ModelAttribute Artista artista, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "artista/formartista";
        } else {
        	model.addAttribute(artista);
        	artistaService.addArtista(artista); 
        }
        return "artista/resultsartista";
    }

}
