package br.com.projetotcc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {
	
	@RequestMapping("/")
	public String home(){
		return "login";
		
	}
}
