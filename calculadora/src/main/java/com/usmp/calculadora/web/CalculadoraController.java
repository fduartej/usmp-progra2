package com.usmp.calculadora.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.usmp.calculadora.model.Calculadora;


@Controller
public class CalculadoraController {

	@GetMapping("/")
	public String load(Model model) {
		model.addAttribute("calculadora", new Calculadora());
		return "calculadora";
	}
	
	@PostMapping("/calcular")
	public String submit(@ModelAttribute Calculadora calculadora) {
		String msg="N/A";
		Double result=0.0;
		if(calculadora.getOperando().equals("+")) {
			result = calculadora.getOperador1() + calculadora.getOperador2();
			msg = "El resultado de la suma de "+
					calculadora.getOperador1() + "+" + calculadora.getOperador2() +
					" es " + result;
		}else if(calculadora.getOperando().equals("-")) {
			result = calculadora.getOperador1() - calculadora.getOperador2();
			msg = "El resultado de la resta de "+
					calculadora.getOperador1() + "-" + calculadora.getOperador2() +
					" es " + result;
		}else if(calculadora.getOperando().equals("*")) {
			result = calculadora.getOperador1() * calculadora.getOperador2();
			msg = "El resultado de la multi de "+
					calculadora.getOperador1() + "*" + calculadora.getOperador2() +
					" es " + result;
		}else {
			if(calculadora.getOperador2()==0.0) {
				msg = "division entre 0 invalida!";
			}else {
				result = calculadora.getOperador1() * calculadora.getOperador2();
				msg = "El resultado de la div de "+
						calculadora.getOperador1() + "/" + calculadora.getOperador2() +
						" es " + result;
			}
		}
		calculadora.setResultado(msg);
		return "result";
	}
	
}
