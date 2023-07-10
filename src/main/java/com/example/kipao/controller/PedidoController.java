package com.example.kipao.controller;

import com.example.kipao.model.Pedido;
import com.example.kipao.repository.PedidoRepository;
import com.example.kipao.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoController(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/recuperar-pedidos/{id}")
    public List<Pedido> recuperarPedidosUsuario(@PathVariable int id){
    return pedidoRepository.findAllByClienteId(id);
    }

    @PostMapping("/criar-pedido")
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

}