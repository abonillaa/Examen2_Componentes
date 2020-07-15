package com.cenfotec.pomponio.web;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PomponioController {
	@GetMapping("/")
	public String index(Model model) throws ParseException {
		return "index";
	}
}
