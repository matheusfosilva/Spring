package br.com.sdconecta.estagio.dto;

import br.com.sdconecta.estagio.model.Oferta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OfertaDTO {

    private long pedidoId;
    @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
    @NotBlank
    private String valor;
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    @NotBlank
    private String dataDeEntrega;
    private String comentario;

    public long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setValor( new BigDecimal( this.valor ) );
        oferta.setDate(LocalDate.parse(this.dataDeEntrega, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        oferta.setComentario(this.comentario);
        return oferta;
    }
}
