package it.uniroma3.spring.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.model.Artista;
import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.service.ArtistaService;
import it.uniroma3.spring.service.OperaService;


@Controller
public class OperaController  {
	
    @Autowired
    private OperaService operaService; 
    @Autowired
	private ArtistaService artistaService;

    //pagina form per raccolta dati
    @GetMapping("admin/opera")
	public String mostraForm(Model model, Opera opera){
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		model.addAttribute("artisti", artisti);
		return "opera/formO";
	}
    
    //descrizione di una opera
    @GetMapping("user/opera/info")
	public String mostraArtista(@RequestParam("id")long id, Model model){
		Opera opera = operaService.findbyId(id);
		model.addAttribute("opera", opera); 
		return "opera/infoOpera";
	}

    //operazione di cancellazione di un'opera
    @GetMapping("admin/opera/cancella")
	public ModelAndView cancellaArtista(@RequestParam("id")long id, Model model){
		operaService.delete(id);
		return new ModelAndView("redirect:/admin/opere");
	}
    
    //opere gestite dal admin
    @GetMapping("/admin/opere")
	public String mostraOpereAdmin(Model model){
		List<Opera> opere = (List<Opera>) operaService.findAll();
		Collections.sort(opere);
		model.addAttribute("opere", opere);
		return "opera/opereA";
	}
    //autori di riferimento all opera
    @GetMapping("/user/opere")
	public String mostraArtisti(Model model){ //al posto di ShowArtista
		List<Opera> opere = (List<Opera>) operaService.findAll();
		Collections.sort(opere);
		model.addAttribute("opere", opere);
		return "opera/opere";
	}
    //controllo post
    @PostMapping("/admin/opera")
	public String controlloClienteInfo(@Valid @ModelAttribute Opera opera, 
			BindingResult bindingResult, Model model) {
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		model.addAttribute("artisti", artisti);
		if (bindingResult.hasErrors()) {
			return "opera/formO";
		}
		else {

			model.addAttribute(opera);
			operaService.add(opera); 
		}
		return "opera/infoOpera";
	}
    
    
    //operazione di modifica opera
	@GetMapping("/admin/opera/modificaO")
	public String modificaOpera2(Model model,@RequestParam("id")Long id) {
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		model.addAttribute("artisti", artisti);
		Opera opera=operaService.findbyId(id);
		model.addAttribute("opera",opera);
		return "opera/modificaO";
	}

    //modifica
	@PostMapping("/admin/opera/modificaO")
	public String modifica(@Valid @ModelAttribute Opera opera, 
			BindingResult bindingResult, Model model ){
		Opera old= opera;
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
		model.addAttribute("artisti", artisti);
		if (bindingResult.hasErrors()) {
			System.out.println("here");
			System.out.println(opera);
			return "opera/modificaO";
		}
		else {
			model.addAttribute(opera);
			operaService.delete(old.getId());
			operaService.add(opera);
		}
		return "opera/infoOpera";
	}
}
    
