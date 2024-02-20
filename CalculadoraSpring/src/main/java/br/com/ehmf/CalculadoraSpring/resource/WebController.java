package br.com.ehmf.CalculadoraSpring.resource;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("modelOperacoes",List.of("Soma","Subtracao"));
		return "index";
	}
	
	@PostMapping("/")
	public String handleFormSubmission(@RequestParam String modelOperacoes,
									   @RequestParam String valor01,
									   @RequestParam String valor02,
									   Model model) {
		
		if(modelOperacoes.isEmpty() || valor01.isEmpty() || valor02.isEmpty()) {
			model.addAttribute("response","Existem campos em branco!");
			return "index";
		}
					
		String resposta = "";
		int res = 0;
		switch(modelOperacoes) {
			case "Soma":
				res = Integer.parseInt(valor01) + Integer.parseInt(valor02);
				break;				
			case "Subtracao":
				res = Integer.parseInt(valor01) - Integer.parseInt(valor02); //Integer.parseInt -> converte de String->Int
				break;
		}
		
		resposta = String.valueOf(res); //converte de Inteiro -> String
		model.addAttribute("modelOperacoes",List.of("Soma","Subtracao"));
		model.addAttribute("response",resposta);
		return "index";
	}
	
}
