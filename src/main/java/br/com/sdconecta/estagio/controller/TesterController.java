package br.com.sdconecta.estagio.controller;

import br.com.sdconecta.estagio.model.status.StatusPedido;
import br.com.sdconecta.estagio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TesterController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping()
    public ModelAndView view(){
        return new ModelAndView("tester/home")
                .addObject("pedidos", pedidoRepository
                        .findByStatusPedido(StatusPedido.ENTREGUE));
    }



}
