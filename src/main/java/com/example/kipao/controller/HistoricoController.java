package com.example.kipao.controller;

import com.example.kipao.model.Pedido2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HistoricoController {

    private List<Pedido2> historicoPedido2s = new ArrayList<>();

    @GetMapping("/historico-pedidos/{clienteId}")
    public List<Pedido2> exibirHistoricoPedidos(@PathVariable int clienteId) {
        // Lógica para recuperar o histórico de pedidos de um cliente pelo ID
        List<Pedido2> historicoCliente = new ArrayList<>();
        for (Pedido2 pedido2 : historicoPedido2s) {
            if (pedido2.getClienteId() == clienteId) {
                historicoCliente.add(pedido2);
            }
        }
        return historicoCliente;
    }
}
