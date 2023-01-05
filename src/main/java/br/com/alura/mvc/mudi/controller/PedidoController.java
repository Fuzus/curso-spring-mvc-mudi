package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.PedidoRequest;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(PedidoRequest request) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Validated PedidoRequest pedidoRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = pedidoRequest.toPedido();
        pedidoRepository.save(pedido);
        return "pedido/formulario";
    }
}
