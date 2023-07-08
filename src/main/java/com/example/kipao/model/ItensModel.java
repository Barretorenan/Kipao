package com.example.kipao.model;


import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItensModel {



        public Integer getId() {
            return id;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_item")
        private Integer id;

    public String getNome() {
        return nome;
    }

    @Column(name = "nome")
        private String nome;

    }

