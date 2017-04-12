package br.com.projetotcc.model;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailRegister {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void send(String to, String subject, String body) throws MessagingException{
		
		MimeMessage mensagem = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(mensagem, true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true);
		
		javaMailSender.send(mensagem);
		
	}
	
	public String formataBody(Usuario usuario){
		String body = "<h4>Olá "+usuario.getNome()+"!</h4>"
				+ "Você realizou o cadastro com sucesso em nosso Aplicativo PicolApp.<br>"
				+ "Seus dados para acesso são:<br><br>"
				+ "Email: "+usuario.getEmail()+"<br>"
				+ "Senha: "+usuario.getSenha()+""
				+ "<br><br>Em caso de dúvidas, entre em contato com o vendedor!";
		
		return body;
	}

	public String formataBodyCobranca(Pedido pedido) {
		String body = "<h4>Olá "+pedido.getUsuario().getNome()+"!</h4>"
				+ "Existem débitos em sua conta do PicolApp no valor de:<br><br>"
				+ "R$ "+pedido.getTotal()+"<br>"
				+ "<br>Por favor, entre em contato com o vendedor!";
		return body;
	}
	

}
