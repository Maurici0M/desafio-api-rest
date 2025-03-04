package com.pedidos.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemDTO {
    private Long idItem;
    private String descricaoItem;
    private BigDecimal valorItem;

    public ItemDTO(Long idItem, String descricaoItem, BigDecimal valorItem) {
        this.idItem = idItem;
        this.descricaoItem = descricaoItem;
        this.valorItem = valorItem;
    }

    //Lombok realiza esse trabalho!
    /*
   public Long getIdItem() {
        return idItem;
    }

   public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

}
