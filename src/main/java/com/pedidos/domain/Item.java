package com.pedidos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    //private int idItem; //foi necessário trocar int por Integer para acessar a verificacao do metodo putAtualizarItemDoPedido
    private Integer id;
    private String descricao;
    private BigDecimal valor;

    //desafio
    @ManyToOne //muitos ítens podem ser adicionados para um pedido
    @JoinColumn(name = "pedido_id")
    @JsonIgnore // Evita o looping de pedidos no json
    private Pedido pedido;

    //Getter e Setter sendo adicionados pelo Lombok automaticamente!

}