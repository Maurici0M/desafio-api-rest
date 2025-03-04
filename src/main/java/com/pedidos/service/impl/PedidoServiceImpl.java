package com.pedidos.service.impl;

import com.pedidos.domain.Item;
import com.pedidos.domain.Pedido;
import com.pedidos.dto.CompradorDTO;
import com.pedidos.dto.ItemDTO;
import com.pedidos.dto.PedidoDTO;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.repository.ItemRepository;
import com.pedidos.repository.PedidoRepository;
import com.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final ItemRepository itemRepository;
    private final PedidoRepository pedidoRepository;
    private final CompradorRepository compradorRepository;

    //RequiredArgsConstructor do Lombok criou o construtor automaticamente!

    @Override
    public Item postCriarPedido(Item item) {
        return itemRepository.save(item);
    }

    public PedidoDTO postPedidoFormatadoDto(Pedido pedido){
        //dados do pedido adicionados via construtor na classe DTO
        var pedidoDTO = new PedidoDTO(
                pedido.getId(),
                pedido.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        );

        //dados do comprador adicionados via construtor na classe DTO
        pedidoDTO.setCompradorDTO(new CompradorDTO(
                (long) pedido.getComprador().getId(),
                pedido.getComprador().getNome(),
                pedido.getComprador().getSobrenome()
        ));

        //dados da lista de ítens adicionados via construtor na classe DTO
        List<ItemDTO> itensDTO = pedido.getListaDeItens().stream().map(item ->  new ItemDTO(
                item.getId(),
                item.getDescricao(),
                item.getValor()
        )).collect(Collectors.toList());

        pedidoDTO.setListaDeItens(itensDTO);

        return pedidoDTO;
    }

    public Pedido getBuscarPedidoById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Item> getListarItensPedido(){
        return itemRepository.findAll();
    }

    public Pedido salvarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }


}
