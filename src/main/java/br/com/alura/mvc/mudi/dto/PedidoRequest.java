package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

import javax.validation.constraints.NotBlank;

public class PedidoRequest {
    @NotBlank
    private String productName;
    @NotBlank
    private String productUrl;
    @NotBlank
    private String imageUrl;
    private String description;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setName(productName);
        pedido.setDescription(description);
        pedido.setImageURL(imageUrl);
        pedido.setProductURL(productUrl);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}
