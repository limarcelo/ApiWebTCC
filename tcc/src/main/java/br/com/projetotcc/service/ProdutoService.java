package br.com.projetotcc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetotcc.model.Produto;
import br.com.projetotcc.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	public Produto cadastrar(Produto produto){
		return produtoRepository.save(produto);
	}

	public Collection<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}
}
