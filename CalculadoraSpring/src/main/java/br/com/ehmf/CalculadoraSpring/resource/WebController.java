package br.com.ehmf.CalculadoraSpring.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String showForm(Model model) {
		return "form";
	}
	
}
