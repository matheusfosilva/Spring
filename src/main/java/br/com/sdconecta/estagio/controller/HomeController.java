package br.com.sdconecta.estagio.controller;

import br.com.sdconecta.estagio.model.status.StatusPedido;
import br.com.sdconecta.estagio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping()
    public String redirectToHome(){
        return "redirect:/home";
    }

    @GetMapping("home")
    public ModelAndView home(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject ("pedidos", pedidoRepository.findAllByUsuario(principal.getName()) );
        return modelAndView;
    }
    @GetMapping("home/{status}")
    public ModelAndView byStatus(@PathVariable("status") String status) {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("pedidos", pedidoRepository.findByStatusPedido(StatusPedido.valueOf(status.toUpperCase())));
        mav.addObject("status", status);
        return mav;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
