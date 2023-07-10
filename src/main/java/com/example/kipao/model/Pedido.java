package com.example.kipao.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_pedido")
    private int id;
    @Column(name = "id_usuario")
    private int clienteId;

    @OneToOne
    @JoinColumn (name = "IdEndereco")
    private Endereco endereco;

//    @Column(name = "valor")
    private double valor;

    @Column(name = "frete")
    private double frete;


    @Column(name = "status")
    private String status;

    @Column(name = "agendamento")
    private LocalDate data;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public String getPedidoStatus() {
        return status;
    }

    public void setPedidoStatus(String string) {
        this.status = string;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}