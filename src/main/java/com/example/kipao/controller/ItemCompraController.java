package com.example.kipao.controller;

import com.example.kipao.model.*;
import com.example.kipao.repository.BoloRepository;
import com.example.kipao.repository.ItemCompraRepository;
import com.example.kipao.repository.ItensRepository;
import com.example.kipao.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemCompraController {

    private final ItemCompraRepository itemCompraRepository;
    private final BoloRepository boloRepository;
    private final PedidoRepository pedidoRepository;
    private final ItensRepository itensRepository;

    public ItemCompraController(ItemCompraRepository itemCompraRepository, BoloRepository boloRepository,
    PedidoRepository pedidoRepository,ItensRepository itensRepository){
        this.itemCompraRepository = itemCompraRepository;
        this.boloRepository = boloRepository;
        this.pedidoRepository = pedidoRepository;
        this.itensRepository = itensRepository;
    }
    @GetMapping("/recuperar-todas-compras")
    public List<ItemCompra> recuperarCompras(){
        return itemCompraRepository.findAll();
    }

    @GetMapping("/recuperar-todas-compras-pedido/{id}")
    public List<ItemCompra> recuperarCompras(@PathVariable int id){
        Pedido pedido = pedidoRepository.findById(id).get();
        return itemCompraRepository.findAllByPedido(pedido);
    }

    @PostMapping("/criar-compra")
    public ItemCompra criarCompra(@RequestBody ItemCompraHelper itemCompra){
        ItemCompra ic = new ItemCompra();

        Bolo bolo = boloRepository.findById(itemCompra.getBolo()).get();
        ic.setBolo(bolo);

        ItemModel item = itensRepository.findById(itemCompra.getItem()).get();
        ic.setItem(item);

        Pedido pedido =pedidoRepository.findById(itemCompra.getPedido()).get();
        ic.setPedido(pedido);
        ic.setValor(itemCompra.getValor());

        ic.setQtd(itemCompra.getQtd());

        return itemCompraRepository.save(ic);
    }

}