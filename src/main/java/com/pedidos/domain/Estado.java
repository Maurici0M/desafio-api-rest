package com.pedidos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Estado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    public Estado() {
    }

    //Getter e Setter sendo adicionados pelo Lombok automaticamente!

}