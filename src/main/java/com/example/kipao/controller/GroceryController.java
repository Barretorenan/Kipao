package com.example.kipao.controller;

import com.example.kipao.model.CarrinhoCompra;
import com.example.kipao.model.ItemCompra;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {

    @PostMapping("/realizar-compra")
    public String realizarCompra(@RequestBody CarrinhoCompra carrinho) {
        // Lógica para realizar a compra na mercearia
        double valorTotal = calcularValorTotal(carrinho);
        return "Compra realizada com sucesso! Valor total: R$" + valorTotal;
    }

    private double calcularValorTotal(CarrinhoCompra carrinho) {
        // Lógica para calcular o valor total da compra (exemplo simplificado)
        double valorTotal = 0.0;
        for (ItemCompra item : carrinho.getItens()) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }
}