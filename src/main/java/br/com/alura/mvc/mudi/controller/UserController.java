package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "usuario")
public class UserController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("pedidos")
    public String home(Model model, Principal principal) {
        List<Pedido> list = pedidoRepository.findAllByUser(principal.getName());
        model.addAttribute("orders", list);
        return "usuario/home";
    }

    @GetMapping("/pedidos/{status}")
    public String byStatus(@PathVariable("status") String status, Model model, Principal principal) {
        List<Pedido> list = pedidoRepository.findByStatusAndUser(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        model.addAttribute("orders", list);
        model.addAttribute("status", status);
        return "usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }
}
