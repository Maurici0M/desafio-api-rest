package com.pedidos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompradorDTO {
    private Long idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;

    //Lombok realiza esse trabalho!
    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }*/

}
