package com.example.kipao.model;

import java.util.List;

public class CarrinhoCompra {

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    private List<ItemCompra> itens;

    // Getters e Setters
}