package com.example.kipao.model;

import javax.persistence.*;

@Entity
@Table(name="bolo")
public class Bolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_bolo")
    Integer id;

    @Column(name="massa")
    String massa;

    @Column(name="recheio")
    String recheio;

    @Column(name="cobertura")
    String cobertura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }
}
