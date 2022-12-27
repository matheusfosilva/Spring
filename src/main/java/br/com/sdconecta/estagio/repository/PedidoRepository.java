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
    List<Pedido> findAllByUser(@Param("username") String username);

    @Query("select p from Pedido p join p.user u where u.username = :username and p.statusPedido = :statusPedido")
    List<Pedido> findAllByStatusAndUser(@Param("statusPedido") StatusPedido statusPedido,
                                        @Param("username") String username);
}
