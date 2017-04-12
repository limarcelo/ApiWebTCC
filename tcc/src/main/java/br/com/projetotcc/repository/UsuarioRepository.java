package br.com.projetotcc.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projetotcc.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u where u.email = ?1 and u.senha = ?2") 
    public Usuario buscaPorEmailSenha(String email, String senha);

	@Query("select u from Usuario u where u.permission = 'USER' ") 
	public Collection<Usuario> buscarTodos();
	
	
}
