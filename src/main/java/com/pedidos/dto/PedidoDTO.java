package com.pedidos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private Long idPedido; // ID da compra
    private String dataPedido; // Data formatada como String
    private CompradorDTO compradorDTO; // Dados do cliente
    private List<ItemDTO> listaDeItens = new LinkedList<>(); // Itens associados

    public PedidoDTO(Long idPedido, String dataPedido) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
    }

    //Lombok realiza esse trabalho!
    /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CompradorDTO getComprador() {
        return comprador;
    }

    public void setComprador(CompradorDTO comprador) {
        this.comprador = comprador;
    }

    public List<ItemDTO> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<ItemDTO> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }*/


}
