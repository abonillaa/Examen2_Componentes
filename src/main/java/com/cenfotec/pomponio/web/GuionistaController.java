package com.cenfotec.pomponio.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cenfotec.pomponio.domain.Guionista;
import com.cenfotec.pomponio.service.GuionistaService;

@Controller
public class GuionistaController {
	@Autowired
	GuionistaService guionistaService;
	
	@GetMapping("/guionista")
	public String guionistaIndex(Model model) throws ParseException {
		model.addAttribute("guionistas", guionistaService.getAllGuionistas());
		return "guionistaIndex";
	}
	
	@GetMapping("/guionista/form")
	public String guionistaForm(Model model) throws ParseException {
		return "guionistaForm";
	}
	
	@PostMapping( "/guionista/form" )
	 public String guionistaForm(@RequestParam MultiValueMap body) throws ParseException 
	 {   
		 String nombre = (String) body .getFirst("nombre");
		 String direccion = (String) body .getFirst("direccion");
		 String fechaNacimiento = (String) body .getFirst("fechaNacimiento");
		 Guionista guionista = new Guionista(nombre,direccion, formatFechaNacimiento(fechaNacimiento));   
		 guionistaService.saveGuionista(guionista);
		 return "redirect:/guionista";
	 }
	
	@GetMapping (value = "/guionista/{id}")
	 public String getGuionistas(Model model, @PathVariable("id") String id) {
		 Long idEntity = Long.parseLong(id);
		 Guionista obj = guionistaService.getGuionista(idEntity).get();
		 model.addAttribute("guionista", obj);
		 return "guionista";
	 }
	
	private Date formatFechaNacimiento(String fecha) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return format.parse(fecha);
	}
}
