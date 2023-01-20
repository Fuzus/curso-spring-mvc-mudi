package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.dto.NewOfferRequest;
import br.com.alura.mvc.mudi.model.Offer;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<Offer> createOferta(@Valid @RequestBody NewOfferRequest request) {

        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(request.getPedidoId());
        if (!pedidoBuscado.isPresent()) {
            return null;
        }

        Pedido pedido = pedidoBuscado.get();
        Offer offer = request.toOffer();
        offer.setPedido(pedido);
        pedido.getOffers().add(offer);

        pedidoRepository.save(pedido);

        return ResponseEntity.ok().body(offer);
    }
}
