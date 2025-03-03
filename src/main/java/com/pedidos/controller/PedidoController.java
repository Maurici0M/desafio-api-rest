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
    /*public PedidoController(PedidoService service) {
        this.service = service;
    }*/

    //cria pedidos
    @PostMapping
    public ResponseEntity<Pedido> postCriarPedidoComItens(@RequestBody Pedido pedido) {
        // Associa os itens ao pedido antes de salvar (corrigindo erro de null no envio)
        pedido.getListaDeItens().forEach(item -> item.setPedido(pedido));

        // Salva o pedido e os itens associados
        Pedido pedidoSalvo = service.salvarPedido(pedido);
        return ResponseEntity.ok(pedidoSalvo);
    }

    //encontra um pedido pelo seu ID
    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDTO> getListarPedidoById(@PathVariable Long idPedido) {
        Pedido pedido = service.getBuscarPedidoById(idPedido);

        // Converte o pedido para o formato DTO
        PedidoDTO pedidoDTO= service.postPedidoFormatadoDto(pedido);

        return ResponseEntity.ok(pedidoDTO);
    }

    //lista todos os itens dos pedidos realizados
    @GetMapping
    public ResponseEntity<List<Item>> getListarItens() {
        List<Item> listaDeItens = service.getListarItensPedido();
        return ResponseEntity.ok(listaDeItens);
    }

}
