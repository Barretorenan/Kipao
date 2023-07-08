package com.example.kipao.model;

import java.time.LocalDate;

public class Pedido2 {

    private int id;
    private int clienteId;
    private String descricao;
    private double valorTotal;
    private PedidoStatus status;
    private Boolean agendado;
    private Boolean CriarEventoAgenda;

    private Boolean EncomendadarBolo;
    private Double PrecoTotal;
    private LocalDate DataEntrega;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Boolean getAgendado() {
        return agendado;
    }

    public void setAgendado(Boolean agendado) {
        this.agendado = agendado;
    }

    public Boolean getCriarEventoAgenda() {
        return CriarEventoAgenda;
    }

    public void setCriarEventoAgenda(Boolean criarEventoAgenda) {
        CriarEventoAgenda = criarEventoAgenda;
    }

    public Boolean getEncomendadarBolo() {
        return EncomendadarBolo;
    }

    public void setEncomendadarBolo(Boolean EncomendadarBolo) {
        EncomendadarBolo = EncomendadarBolo;
    }

    public Double getPrecoTotal() {
        return PrecoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        PrecoTotal = precoTotal;
    }

    public LocalDate getDataEntrega() {
        return DataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        DataEntrega = dataEntrega;
    }

    public boolean GetEncomendarBolo() {
        return EncomendadarBolo;
    }

    // Getters e Setters
}