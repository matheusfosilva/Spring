package br.com.sdconecta.estagio.api;

import br.com.sdconecta.estagio.dto.OfertaDTO;
import br.com.sdconecta.estagio.model.Oferta;
import br.com.sdconecta.estagio.model.Pedido;
import br.com.sdconecta.estagio.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta creatOferta(@Valid @RequestBody OfertaDTO ofertaDTO){
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(ofertaDTO.getPedidoId());

        if (!pedidoBuscado.isPresent()){
            return null;
        }

        Pedido pedido = pedidoBuscado.get();
        Oferta oferta = ofertaDTO.toOferta();
        oferta.setPedido(pedido);
        pedido.getOfertas().add(oferta);

        pedidoRepository.save(pedido);

        return oferta;
    }


}
