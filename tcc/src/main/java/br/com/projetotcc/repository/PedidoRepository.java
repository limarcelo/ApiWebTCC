package br.com.projetotcc.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projetotcc.model.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Query("select p from Pedido p where p.usuario.id = :id ORDER BY id_pedido DESC") 
	public Collection<Pedido> listarPedidoPorUser(@Param("id") Integer id);

	
	@Query("select p from Pedido p where p.status = 'Novo' ORDER BY idPedido DESC") 
	public Collection<Pedido> listarTodosPedido();
	
	@Query("select p from Pedido p where p.status = 'Entregue' and p.tipoPagamento = 'Pagar depois' and p.usuario.id=:id") 
	public Collection<Pedido> listarPedidoContasPagar(@Param("id") Integer id);

}
