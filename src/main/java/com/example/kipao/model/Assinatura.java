package com.example.kipao.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="assinatura")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_assinatura")
    private int id;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Column(name = "tipo")
    private String tipo;
    @Column(name = "status")
    private String status;
    @Column(name = "recorrencia")
    private String recorrencia;

    @Column(name = "horario")
    private LocalDateTime horario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido idPedido) {
        this.pedido = idPedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String starus) {
        this.status = starus;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }
    // Outros atributos do plano de assinatura

    // Getters e Setters
}
