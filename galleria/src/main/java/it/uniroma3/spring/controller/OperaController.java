package it.uniroma3.spring.controller;

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

///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
/////////////////Al posto di stanza fare il catalogo o percorso//////////////////////

@Controller
public class OperaController  {
	
    @Autowired
    private OperaService operaService; 
    @Autowired
	private ArtistaService artistaService;

    //pagina form per raccolta dati
    @GetMapping("admin/opera")
	public String mostraForm(Model model, Opera opera){
		List<Artista> artista = (List<Artista>) artistaService.findAll();
//		List<Stanza>stanze= (List<Stanza>) stanzaService.findAll();
		model.addAttribute("artista", artista);
//		model.addAttribute("stanze",stanze);
		return "opera/formO";
	}
    
    //descrizione di una opera
    @GetMapping("opera/infoOpera")
	public String mostraArtista(@RequestParam("id")long id, Model model){
		Opera opera = operaService.findbyId(id);
		model.addAttribute("opera", opera); 
		return "opera/infoOpera";
	}

    //operazione di cancellazione sul opera
    @GetMapping("admin/opera/cancella")
	public ModelAndView cancellaArtista(@RequestParam("id")long id, Model model){
		operaService.delete(id);
		return new ModelAndView("redirect:/opere");
	}
    
    //opere gestite dal admin
    @GetMapping("/admin/opereAdmin")
	public String mostraOpereAdmin(Model model){
		List<Opera> opere = (List<Opera>) operaService.findAll();
		model.addAttribute("opere", opere);
		return "opera/opereA";
	}
    //autori di riferimento all opera
    @GetMapping("/user/opere")
	public String mostraArtisti(Model model){ //al posto di ShowArtista
		List<Opera> opere = (List<Opera>) operaService.findAll();
		model.addAttribute("opere", opere);
		return "opera/opere";
	}
/////////////////////////////////////////////Giacomo per commenti////////////////////////////	
	//controllo post
    @PostMapping("/opera")
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
//		List<Stanza>stanze= (List<Stanza>) stanzaService.findAll();
		model.addAttribute("autori", artisti);
//		model.addAttribute("stanze",stanze);
		Opera opera=operaService.findbyId(id);
		model.addAttribute("opera",opera);
		return "opera/modificaO";
	}

    //modidica
	@PostMapping("/admin/opera/modificaO")
	public String controlloCliente(@Valid @ModelAttribute Opera opera, 
			BindingResult bindingResult, Model model ){
		List<Artista> artisti = (List<Artista>) artistaService.findAll();
//		List<Stanza>stanze= (List<Stanza>) stanzaService.findAll();
		model.addAttribute("autori", artisti);
//		model.addAttribute("stanze",stanze);
		if (bindingResult.hasErrors()) {
			return "opera/modificaO";
		}
		else {
			model.addAttribute(opera);
			try{
				operaService.add(opera);
			}catch(Exception e){
				return"opera/modificaO";

			}
		}
		return "opera/infoOpera";
	}
}
    
