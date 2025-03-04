package com.pedidos.dto.atualizacao;

import com.pedidos.dto.ItemDTO;

import java.util.LinkedList;
import java.util.List;

public class AtualizarPedidoDTO {
    private Long idPedido;
    private List<ItemDTO> listaDeItens = new LinkedList<>();
}
