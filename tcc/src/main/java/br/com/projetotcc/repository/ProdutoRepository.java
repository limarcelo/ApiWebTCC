package br.com.projetotcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetotcc.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
}


