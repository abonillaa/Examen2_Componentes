package com.cenfotec.pomponio.web;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cenfotec.pomponio.domain.Guion;
import com.cenfotec.pomponio.service.GuionService;

@Controller
public class GuionController {
	@Autowired
	GuionService guionService;
	
	@GetMapping("/guion")
	public String guionIndex(Model model) throws ParseException {
		model.addAttribute("guiones", guionService.getAllGuiones());
		return "guionIndex";
	}
	
	@GetMapping("/guionForm")
	public String guionForm(Model model) throws ParseException {
		return "guionIndex";
	}
	
	@PostMapping( "guionForm" )
	 public void guionForm(@RequestParam MultiValueMap body) throws ParseException 
	 {   
		 String nombre = (String) body .getFirst("nombre");
		 String genero = (String) body .getFirst("genero");
		 String ideaCentral = (String) body .getFirst("ideaCentral");
		 Guion guion = new Guion(nombre,genero, ideaCentral);   
		 guionService.saveGuion(guion);
	 }
	
	@GetMapping (value = "/guion/{id}")
	 public String getGuion(Model model, @PathVariable("id") String id) {
		 Long idEntity = Long.parseLong(id);
		 Guion obj = guionService.getGuion(idEntity).get();
		 model.addAttribute("guion", obj);
		 return "guion";
	 }
	
}
