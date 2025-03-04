package com.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CompradorDTO {
    private Long idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;

    //AllArgsConstructor do Lombok criou o construtor automaticamente e adicionou todas as variáveis nele!

    //Getter e Setter sendo adicionados pelo Lombok automaticamente!

}
