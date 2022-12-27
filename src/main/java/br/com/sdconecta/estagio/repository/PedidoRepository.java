package br.com.sdconecta.estagio.repository;

import br.com.sdconecta.estagio.model.Pedido;
import br.com.sdconecta.estagio.model.status.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
    @Query("select p from Pedido p join p.user u where u.username = :username ")
    List<Pedido> findAllByUsuario(@Param("username") String username);
}
