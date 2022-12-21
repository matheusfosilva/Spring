package br.com.sdconecta.estagio.dto;

import br.com.sdconecta.estagio.model.Pedido;
import jakarta.validation.constraints.NotBlank;

public class PedidoDTO {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    @NotBlank
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setName(this.nomeProduto);
        pedido.setDescription(this.descricao);
        pedido.setUrlImage(this.urlImagem);
        pedido.setUrlProduct(this.urlProduto);
        return pedido;
    }
}
