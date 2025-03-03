package com.pedidos.service;

import com.pedidos.domain.Item;
import com.pedidos.domain.Pedido;
import com.pedidos.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {

    //POST
    Item postCriarPedido(Item item);

    //GET
    List<Item> getListarItensPedido();

    Pedido getBuscarPedidoById(Long id);

    Pedido salvarPedido(Pedido pedido);

    PedidoDTO postPedidoFormatadoDto(Pedido pedido);


}
