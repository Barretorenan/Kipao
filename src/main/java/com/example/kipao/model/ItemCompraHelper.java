package com.example.kipao.model;

import javax.persistence.*;

public class ItemCompraHelper {
    private int id;

    private int pedido;

    private int item;

    private int bolo;

    private int qtd;

    private double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getBolo() {
        return bolo;
    }

    public void setBolo(int bolo) {
        this.bolo = bolo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
