package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;

public class PedidoRequest {
    private String productName;
    private String productUrl;
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
        return pedido;
    }
}
