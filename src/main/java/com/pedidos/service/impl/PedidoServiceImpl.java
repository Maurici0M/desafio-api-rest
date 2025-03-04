package com.pedidos.service.impl;

import com.pedidos.domain.Comprador;
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
    /*public PedidoServiceImpl(ItemRepository itemRepository, PedidoRepository pedidoRepository) {
        this.itemRepository = itemRepository;
        this.pedidoRepository = pedidoRepository;
    }*/

    @Override
    public Item postCriarPedido(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getListarItensPedido(){
        return itemRepository.findAll();
    }

    public Pedido getBuscarPedidoById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido salvarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    /*public PedidoDTO postPedidoFormatadoDto(Pedido pedido){
        //Dados do pedido
        var pedidoDto = new PedidoDTO();
        pedidoDto.setIdPedido(pedido.getId());
        pedidoDto.setDataPedido(pedido.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        //Dados do comprador
        var compradorDto = new CompradorDTO();
        compradorDto.setIdCliente((long) pedido.getComprador().getId());
        compradorDto.setNomeCliente(pedido.getComprador().getNome());
        compradorDto.setSobrenomeCliente(pedido.getComprador().getSobrenome());
        pedidoDto.setCompradorDTO(compradorDto);

        //Dados dos itens sendo formatados através do DTO
        List<ItemDTO> itensDto = pedido.getListaDeItens().stream().map(item -> {
            var itemDto = new ItemDTO();
            itemDto.setIdItem( (long) item.getId()); //casting
            itemDto.setDescricaoItem(item.getDescricao());
            itemDto.setValorItem(item.getValor());

            return itemDto;
        }).collect(Collectors.toList());

        //adicionando os itens mapeados ao pedidoDto
        pedidoDto.setListaDeItens(itensDto);

        return pedidoDto;
    }*/

    public PedidoDTO postPedidoFormatadoDto(Pedido pedido){
        //dados do pedido adicionados via construtor na classe DTO
        var pedidoDTO = new PedidoDTO(
                pedido.getId(),
                pedido.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        );

        var compradorDTO = new CompradorDTO(
                (long) pedido.getComprador().getId(),
                pedido.getComprador().getNome(),
                pedido.getComprador().getSobrenome()
        );

        //dados do pedido adicionados via construtor na classe DTO
        List<ItemDTO> itensDTO = pedido.getListaDeItens().stream().map(item ->  new ItemDTO(
            (long) item.getId(),
            item.getDescricao(),
            item.getValor()
        )).collect(Collectors.toList());

        pedidoDTO.setListaDeItens(itensDTO);

        return pedidoDTO;
    }

}
