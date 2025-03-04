package com.pedidos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private long idPedido; // ID da compra
    private String dataPedido; // Data formatada como String
    private CompradorDTO compradorDTO; // Dados do cliente
    private List<ItemDTO> listaDeItens = new LinkedList<>(); // Itens associados

    public PedidoDTO(Long idPedido, String dataPedido) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
    }

    //Getter e Setter sendo adicionados pelo Lombok automaticamente!

}
