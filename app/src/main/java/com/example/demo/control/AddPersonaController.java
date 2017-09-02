package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Persona;

@Controller
public class AddPersonaController {

	@GetMapping("/addPerson")
	public String loadFormPerson(Model model) {
		model.addAttribute("persona", new Persona());
		return "addPerson";
	}
	
	@PostMapping("/addPerson")
	public String submitPerson(@ModelAttribute Persona persona) {
		int total= persona.getEdad()+ persona.getIncremento();
		persona.setIncremento(total);
		return "result";
	}
}
