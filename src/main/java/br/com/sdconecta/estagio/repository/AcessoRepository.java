package br.com.sdconecta.estagio.repository;

import br.com.sdconecta.estagio.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso,Long> {

}
