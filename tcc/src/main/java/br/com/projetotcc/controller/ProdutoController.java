package br.com.projetotcc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetotcc.model.Produto;
import br.com.projetotcc.service.ProdutoService;

@RestController
@RequestMapping ("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(method=RequestMethod.POST, value="/salvar", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
		
		Produto produtoCadastrado = produtoService.cadastrar(produto);
		return new ResponseEntity<>(produtoCadastrado, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Produto>> listarTodosProdutos(){
		
		Collection<Produto> produtosBuscados = produtoService.buscarTodos();
		return new ResponseEntity<>(produtosBuscados,  HttpStatus.OK);
	}
}
