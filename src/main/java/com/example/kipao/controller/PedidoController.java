package com.example.kipao.controller;

import com.example.kipao.model.Pedido2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    @PostMapping("/pedidos")
    public String criarPedido(@RequestBody Pedido2 pedido2) {
        // Lógica para criar um novo pedido no sistema
        // ...

        if (pedido2.GetEncomendarBolo()) {
            // Verifica se o pedido é para encomendar um bolo personalizado
            encomendarBolo(pedido2);
        }

        return "Pedido criado com sucesso!";
    }

    private void encomendarBolo(Pedido2 pedido2) {
        // Lógica para encomendar um bolo personalizado
        // Pode envolver o cálculo do preço total, confirmação do pedido, etc.
        // ...

        // Exemplo de código para mostrar o preço total e a data/horário da entrega
        System.out.println("Preço Total: " + pedido2.getPrecoTotal());
        System.out.println("Data de Entrega: " + pedido2.getDataEntrega());
    }
}