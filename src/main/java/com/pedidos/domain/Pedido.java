package com.pedidos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "comprador")
    @ManyToOne //vários compradores podem ser associados a um pedido
    private Comprador comprador;

    //desafio
    @OneToMany(mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Item> listaDeItens = new LinkedList<>();

    //usando o formatador de data para voltar na formatação correta:
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data;

    @PrePersist
    public void prePersist() {
        this.data = LocalDateTime.now();
    } //captura a data e hora atual

    //Getter e Setter sendo adicionados pelo Lombok automaticamente!

}

