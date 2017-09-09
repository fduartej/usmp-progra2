package com.example.demo.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Persona;
import com.example.demo.model.PersonaRepository;

@Controller
public class AddPersonaController {

	@Autowired
	private PersonaRepository personaRepo;

	@GetMapping("/addPerson")
	public String loadFormPerson(Model model) {
		model.addAttribute("persona", new Persona());
		return "addPerson";
	}

	@PostMapping("/addPerson")
	public String submitPerson(@ModelAttribute Persona persona) {

		personaRepo.save(persona);

		int total = persona.getEdad() + persona.getIncremento();
		persona.setIncremento(total);
		return "result";
	}

	@GetMapping("/listPerson")
	public String list(Map<String, Object> model) {
		List<Persona> pers = personaRepo.findAll();
		model.put("pers", pers);
		return "persList";
	}
}