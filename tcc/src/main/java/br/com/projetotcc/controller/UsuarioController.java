package br.com.projetotcc.controller;

import java.util.Collection;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetotcc.model.Credencial;
import br.com.projetotcc.model.Pedido;
import br.com.projetotcc.model.Usuario;
import br.com.projetotcc.service.UsuarioService;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, value="/salvar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) throws MessagingException{
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> autenticarUsuario(@RequestBody Credencial credencial){
		Usuario usuarioAutenticado = usuarioService.autenticarUsuario(credencial);
		return new ResponseEntity<Usuario>(usuarioAutenticado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listar")
	public ResponseEntity<Collection<Usuario>> buscarTodos(){
		
		Collection<Usuario> usuariosBuscados = usuarioService.buscarTodos();
		return new ResponseEntity<>(usuariosBuscados,  HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/enviarCobranca", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> enviarCobranca(@RequestBody Pedido pedido) throws MessagingException{
		Usuario usuarioCobrado = usuarioService.enviarCobranca(pedido);
		return new ResponseEntity<Usuario>(usuarioCobrado, HttpStatus.OK);
	}
	
	
	

}
