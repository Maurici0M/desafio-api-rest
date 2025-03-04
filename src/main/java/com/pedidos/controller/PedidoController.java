package com.pedidos.controller;

import com.pedidos.domain.Item;
import com.pedidos.domain.Pedido;
import com.pedidos.dto.PedidoDTO;
import com.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService service;

    //RequiredArgsConstructor do Lombok criou o construtor automaticamente!

    @PostMapping
    public ResponseEntity<Pedido> postCriarPedidoComItens(@RequestBody Pedido pedido) {
        // Associa os itens ao pedido antes de salvar (corrigindo erro de null no envio)
        pedido.getListaDeItens().forEach(
                item -> item.setPedido(pedido)
        );

        // Salva o pedido e os itens associados
        Pedido pedidoSalvo = service.salvarPedido(pedido);
        return ResponseEntity.ok(pedidoSalvo);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDTO> getListarPedidoById(@PathVariable Long idPedido) {
        Pedido pedido = service.getBuscarPedidoById(idPedido);

        // Converte o pedido para o formato DTO
        PedidoDTO pedidoDTO = service.postPedidoFormatadoDto(pedido);

        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getListarItens() {
        List<Item> listaDeItens = service.getListarItensPedido();
        return ResponseEntity.ok(listaDeItens);
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<Pedido> putAtualizarPedido(@PathVariable Long idPedido, @RequestBody Pedido pedidoAtualizado) {
        // Busca o pedido existente pelo ID
        Pedido pedidoExistente = service.getBuscarPedidoById(idPedido);

        // Atualiza os dados do pedido existente com os novos valores
        pedidoExistente.setComprador(pedidoAtualizado.getComprador());
        pedidoExistente.getListaDeItens().clear(); // Remove itens antigos
        pedidoAtualizado.getListaDeItens().forEach(item -> item.setPedido(pedidoExistente));
        pedidoExistente.getListaDeItens().addAll(pedidoAtualizado.getListaDeItens());

        // Salva as alterações no banco
        Pedido pedidoSalvo = service.salvarPedido(pedidoExistente);

        return ResponseEntity.ok(pedidoSalvo);
    }

    @PutMapping("/{idPedido}/itens/{idItem}")
    public ResponseEntity<Item> putAtualizarItemDoPedido (@PathVariable Long idPedido,
                                                          @PathVariable Integer idItem,
                                                          @RequestBody Item itemAtualizado ){

        //capturando o id do pedido
        Pedido pedido = service.getBuscarPedidoById(idPedido);

        //verificando se o ‘id’ do ‘item’ procurado faz parte da nossa lista de itens
        Item itemExistente = pedido.getListaDeItens().stream()
                .filter(item -> item.getId().equals(idItem))
                .findFirst()
                .orElse(null);

        //verifica se o id do iten digitado é nulo ou nao para setar o novo valor ou emitir notFound
        if (itemExistente != null) {
            itemExistente.setDescricao(itemAtualizado.getDescricao());
            itemExistente.setValor(itemAtualizado.getValor());
        }
        else {
            ResponseEntity.notFound().build();
        }

        //salvando o pedido que capturamos pelo id na linha 67
        Pedido pedidoAtualizado = service.salvarPedido(pedido);

        //return null;
        return ResponseEntity.ok(itemExistente);
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<Pedido> deleteApagarPedido(@PathVariable Long idPedido){
        Pedido pedidoParaSerExcluido = service.deleteApagarPedidoById(idPedido);

        return ResponseEntity.ok(pedidoParaSerExcluido);
    }

}


