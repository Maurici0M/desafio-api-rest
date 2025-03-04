package com.pedidos.controller;

import com.pedidos.domain.Comprador;
import com.pedidos.service.CompradorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("comprador")
public class CompradorController {
    private final CompradorService service;

    //RequiredArgsConstructor do Lombok criou o construtor automaticamente!

    //criar comprador - Gui
    @PostMapping
    private ResponseEntity<Comprador> postCriarComprador(@RequestBody Comprador comprador) {
        Comprador c = service.postCriarComprador(comprador);

        return ResponseEntity.ok(c);
    }

    //listar todos os compradores - Gui
    @GetMapping("/listar/compradores")
    private ResponseEntity<List<Comprador>> getCompradores() {
        List<Comprador> compradores = service.getListarCompradores();

        return ResponseEntity.ok(compradores);
    }

    //listar comprador único por id - Desafio
    @GetMapping("/{idComprador}")
    public ResponseEntity<Comprador> getCompradorById(@PathVariable int idComprador){
        Comprador compradorPorId = service.getListaCompradorById(idComprador);

        if (compradorPorId == null){
            //throw new RuntimeException("Erro 404! Cliente não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(compradorPorId);
    }

    //criar metodo para cadastrar varios clientes de uma so vez - Desafio - TESTE
    @PostMapping("/teste")
    public ResponseEntity<List<Comprador>> postCriarVariosCompradores(@RequestBody List<Comprador> listaDeCompradores){
        List<Comprador> compradoresAdicionados = new LinkedList<>();

        for(Comprador comprador : listaDeCompradores) {
            Comprador compradorSalvo = service.postCriarComprador(comprador);
            compradoresAdicionados.add(compradorSalvo);
        }

        return ResponseEntity.ok(compradoresAdicionados);
    }

}