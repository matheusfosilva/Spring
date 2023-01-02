package br.com.sdconecta.estagio.api;

import br.com.sdconecta.estagio.model.Acesso;
import br.com.sdconecta.estagio.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("acessos")
@RestController
public class AcessRest {

    @Autowired
    private AcessoRepository acessoRepository;

    @GetMapping
    public List<Acesso> getAcessos() {
        return acessoRepository.findAll();
    }
}
