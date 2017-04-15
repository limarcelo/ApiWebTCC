package br.com.projetotcc;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {
	
	@RequestMapping("/home")
	public String home(){
		return "home";
		
	}
	
	
        
}
