package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pedidos")
public class PedidosRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("aguardando")
    public ResponseEntity<List<Pedido>> getPedidosAguardandoOferta(){
        Sort sort = Sort.by("id").descending();
        PageRequest page = PageRequest.of(0, 10, sort);

        List<Pedido> list = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, page);

        return ResponseEntity.ok().body(list);
    }
}
