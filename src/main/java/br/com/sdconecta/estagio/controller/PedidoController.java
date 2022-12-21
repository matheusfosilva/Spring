package br.com.sdconecta.estagio.controller;

import br.com.sdconecta.estagio.dto.PedidoDTO;
import br.com.sdconecta.estagio.model.Pedido;
import br.com.sdconecta.estagio.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @RequestMapping(method = RequestMethod.GET, value="formulario")
    public String form(){
        return "pedido/formulario";
    }

    @RequestMapping(method = RequestMethod.POST, value="novo")
    public String novo(@Valid PedidoDTO req, BindingResult result){

        if(result.hasErrors()){ return "pedido/formulario"; }

        Pedido pedido = req.toPedido();
        repository.save(pedido);
        return "pedido/formulario";
    }
}
