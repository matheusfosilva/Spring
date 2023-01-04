package br.com.sdconecta.estagio.controller;

import br.com.sdconecta.estagio.model.status.StatusPedido;
import br.com.sdconecta.estagio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;
    private static PageRequest pageRequest = PageRequest.of(0, 5, Sort.by("id").descending());

    @GetMapping()
    public ModelAndView view(){
        return new ModelAndView("tester/home")
                .addObject("pedidos", pedidoRepository
                        .findByStatusPedido(StatusPedido.ENTREGUE, pageRequest));
    }

    @GetMapping("home")
    public ModelAndView home(Principal principal) {

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject ("pedidos", pedidoRepository.findAllByUser(principal.getName(), pageRequest) );
        return modelAndView;
    }
    @GetMapping("home/{status}")
    public ModelAndView byStatus(@PathVariable("status") String status, Principal principal) {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("pedidos", pedidoRepository.findAllByStatusAndUser(
                StatusPedido.valueOf(status.toUpperCase()), principal.getName(), pageRequest)
        );
        mav.addObject("status", status);
        return mav;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
