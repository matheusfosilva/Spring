package br.com.sdconecta.estagio.repository;

import br.com.sdconecta.estagio.model.Pedido;
import br.com.sdconecta.estagio.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
