package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Offer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewOfferRequest {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long pedidoId;
    private String price;

    private String deliveryDate;

    private String comment;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Offer toOffer(){
        Offer offer = new Offer();
        offer.setComment(this.comment);
        offer.setDeliveryDate(LocalDate.parse(this.deliveryDate, formatter));
        offer.setPrice(new BigDecimal(this.price));
        return offer;
    }
}
