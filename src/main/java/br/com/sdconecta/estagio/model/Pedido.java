package br.com.sdconecta.estagio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String name;
    private BigDecimal price;
    private LocalDate date;
    private String urlProduct;
    private String urlImage;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    public Pedido() {
        this.setStatusPedido(StatusPedido.AGUARDANDO);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUrlProduct() {
        return urlProduct;
    }

    public void setUrlProduct(String urlProduct) {
        this.urlProduct = urlProduct;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
