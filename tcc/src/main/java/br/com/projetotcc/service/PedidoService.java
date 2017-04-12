package br.com.projetotcc.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetotcc.model.Pedido;
import br.com.projetotcc.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido adicionar(Pedido pedido){
		return pedidoRepository.save(pedido);
	}
	
	public Collection<Pedido> listarPedidoPorUser(Integer id){
		return pedidoRepository.listarPedidoPorUser(id);
	}
	
	public Collection<Pedido> listarTodosPedido( ){
		return pedidoRepository.listarTodosPedido();
	}
	
	public Collection<Pedido> listarPedidoContasPagar(Integer id){
		return pedidoRepository.listarPedidoContasPagar(id);
	}

	public Pedido editarStatus(Pedido pedido) {
		
		Date date = new Date();
		pedido.setDataPedido(date);
		return pedidoRepository.save(pedido);
	}

	
	
}
