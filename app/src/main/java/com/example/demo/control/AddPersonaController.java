package com.example.demo.control;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String submitPerson(@Valid 
			Persona persona, BindingResult result) {
		if(result.hasErrors()) {
			
			return "addPerson";
		}else {
			personaRepo.save(persona);
			int total = persona.getEdad() + persona.getIncremento();
			persona.setIncremento(total);
			return "result";
		}
	}
	
	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute Persona persona) {
		personaRepo.save(persona);
		return "result";
	}
	

	@GetMapping("/listPerson")
	public String list(Map<String, Object> model) {
		List<Persona> pers = personaRepo.findAll();
		model.put("pers", pers);
		return "persList";
	}
	
	@GetMapping(value = "/person/{personId}/edit")
	public String editPerson(@PathVariable("personId") long id,
			Model model) {
		Persona person =personaRepo.findOne(id);
		model.addAttribute(person);
		return "editPerson";
	}
}