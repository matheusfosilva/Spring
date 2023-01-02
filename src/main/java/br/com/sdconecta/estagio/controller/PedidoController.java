package br.com.sdconecta.estagio.controller;

import br.com.sdconecta.estagio.dto.PedidoDTO;
import br.com.sdconecta.estagio.model.Pedido;
import br.com.sdconecta.estagio.repository.PedidoRepository;
import br.com.sdconecta.estagio.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "formulario")
    public String form(PedidoDTO req) {
        return "pedido/formulario";
    }

    @RequestMapping(method = RequestMethod.POST, value = "novo")
    public String novo(@Valid PedidoDTO req, BindingResult result) {

        if (result.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = req.toPedido();

        pedido.setUser(userRepository.findByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        ));

        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}
