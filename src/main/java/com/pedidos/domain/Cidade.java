package com.pedidos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cidade")
public class Cidade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @JoinColumn(name = "estado")
    @ManyToOne
    private Estado estado;

    //Lombok realiza esse trabalho!
    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }*/

}
