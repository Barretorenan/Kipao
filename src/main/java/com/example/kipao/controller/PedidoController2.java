package com.example.kipao.controller;

import com.example.kipao.model.Pedido2;
import com.example.kipao.model.PedidoStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PedidoController2 {

    private List<Pedido2> pedido2s = new ArrayList<>();

    @PutMapping("/atualizar-pedido/{id}")
    public String atualizarPedido(@PathVariable int id, @RequestBody PedidoStatus status) {
        // Lógica para atualizar o status de um pedido pelo ID
        if (id >= 0 && id < pedido2s.size()) {
            Pedido2 pedido2 = pedido2s.get(id);
            pedido2.setStatus(status);
            return "Status do pedido atualizado com sucesso!";
        }
        return "Pedido não encontrado!";
    }

    @DeleteMapping("/finalizar-pedido/{id}")
    public String finalizarPedido(@PathVariable int id) {
        // Lógica para finalizar um pedido pelo ID
        if (id >= 0 && id < pedido2s.size()) {
            Pedido2 pedido2 = pedido2s.get(id);
            pedido2.setStatus(PedidoStatus.FINALIZADO);
            return "Pedido finalizado com sucesso!";
        }
        return "Pedido não encontrado!";
    }

    @GetMapping("/listar-pedidos")
    public List<Pedido2> listarPedidos() {
        // Retorna a lista de pedidos
        return pedido2s;
    }
}
