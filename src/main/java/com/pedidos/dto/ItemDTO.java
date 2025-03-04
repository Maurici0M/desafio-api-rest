package com.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ItemDTO {
    private Integer idItem;
    private String descricaoItem;
    private BigDecimal valorItem;

    //AllArgsConstructor do Lombok criou o construtor automaticamente e adicionou todas as variáveis nele!

    //Getter e Setter sendo adicionados pelo Lombok automaticamente!

}
