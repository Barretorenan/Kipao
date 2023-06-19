package com.example.echo;

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

        @Column(name = "nome")
        private String quote;

    }

