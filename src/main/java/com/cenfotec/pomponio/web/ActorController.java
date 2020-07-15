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
import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.service.ActorService;

@Controller
public class ActorController {
	@Autowired
	ActorService actorService;
	
	@GetMapping("/actor")
	public String actorIndex(Model model) throws ParseException {
		model.addAttribute("actores", actorService.getAllActores());
		return "actorIndex";
	}
	
	@GetMapping("/actor/form")
	public String actorForm(Model model) throws ParseException {
		return "actorForm";
	}
	
	@PostMapping( "/actor/form" )
	 public String actorForm(Model model, @RequestParam MultiValueMap body) throws ParseException 
	 {   
		 String nombre = (String) body .getFirst("nombre");
		 String genero = (String) body .getFirst("genero");
		 String estatura = (String) body .getFirst("estatura");
		 String complexion = (String) body .getFirst("complexion");
		 String colorOjos = (String) body .getFirst("colorOjos");
		 String colorPelo = (String) body .getFirst("colorPelo");
		 String fechaNacimiento = (String) body .getFirst("fechaNacimiento");
		 Actor actor = new Actor(nombre,genero, estatura, complexion, colorOjos, colorPelo, formatFechaNacimiento(fechaNacimiento));   
		 actorService.saveActor(actor);
		 return "actorForm";
	 }
	
	@GetMapping (value = "/actor/{id}")
	 public String getActor(Model model, @PathVariable("id") String id) {
		 Long idEntity = Long.parseLong(id);
		 Actor obj = actorService.getActor(idEntity).get();
		 model.addAttribute("actor", obj);
		 return "actor";
	 }
	
	private Date formatFechaNacimiento(String fecha) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return format.parse(fecha);
	}
}
