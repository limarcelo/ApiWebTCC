package br.com.projetotcc.service;

import java.util.Collection;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetotcc.model.Credencial;
import br.com.projetotcc.model.EmailRegister;
import br.com.projetotcc.model.Pedido;
import br.com.projetotcc.model.Usuario;
import br.com.projetotcc.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	private EmailRegister emailRegister;
	
	public Usuario cadastrar(Usuario usuario) throws MessagingException{
		
		usuario.setPermission("USER");
		String body = emailRegister.formataBody(usuario);
		emailRegister.send(usuario.getEmail(), "Cadastro concluído - PicolApp!", body);

		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorId(Integer id){
		return usuarioRepository.findOne(id);
	}
	
	public Usuario autenticarUsuario(Credencial credencial){
		return usuarioRepository.buscaPorEmailSenha(credencial.getEmail(), credencial.getSenha());
	}
	
	public Collection<Usuario> buscarTodos(){
		return usuarioRepository.buscarTodos();
	}

	public Usuario enviarCobranca(Pedido pedido) throws MessagingException {
		String body = emailRegister.formataBodyCobranca(pedido);
		emailRegister.send(pedido.getUsuario().getEmail(), "Contas à Pagar - PicolApp!", body);
		return pedido.getUsuario();
	}
	
	
}
