package br.com.projetotcc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetotcc.model.Pedido;
import br.com.projetotcc.service.PedidoService;

@RestController
@RequestMapping (value = "/pedido")

public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/adicionar",  produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> adicionar(@RequestBody Pedido pedido) {
		
		Pedido pedidoAdicionado = pedidoService.adicionar(pedido);
		return new ResponseEntity<>(pedidoAdicionado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listar")  
	public ResponseEntity<Collection<Pedido>> listarPedidoPorUser(@RequestHeader(value="id") Integer id) {
		
		Collection<Pedido> pedidosPorId = pedidoService.listarPedidoPorUser(id);
		return new ResponseEntity<>(pedidosPorId, HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/listarContasPagar")  
	public ResponseEntity<Collection<Pedido>> listarPedidoContasPagar(@RequestHeader(value="id") Integer id) {
		
		Collection<Pedido> pedidosContasPagar = pedidoService.listarPedidoContasPagar(id);
		return new ResponseEntity<>(pedidosContasPagar, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarTodos")  
	public ResponseEntity<Collection<Pedido>> listarTodosPedido() {
		
		Collection<Pedido> pedidosPorId = pedidoService.listarTodosPedido();
		return new ResponseEntity<>(pedidosPorId, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editarStatus",  produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)  
	public ResponseEntity<Pedido> editarStatus(@RequestBody Pedido pedido) {
		
		Pedido pedidoEditado = pedidoService.editarStatus(pedido);
		return new ResponseEntity<>(pedidoEditado, HttpStatus.OK);
	}
	

	
}
