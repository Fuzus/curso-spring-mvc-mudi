package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Order order = new Order();
        order.setName("Smartphone Xiaomi Redmi Note 8");
        order.setImageURL("https://m.media-amazon.com/images/I/51RIqTiRc8L._AC_SX679_.jpg");
        order.setProductURL("https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-Camera/dp/B07Z5BBG56/ref=sr_1_1?keywords=redmi+8&qid=1672873627&sr=8-1");
        order.setDescription("Uma descricao qualquer para esse pedido");

        List<Order> list =  Arrays.asList(order);
        model.addAttribute("orders", list);
        return "home";
    }
}
