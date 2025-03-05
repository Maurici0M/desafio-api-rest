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

    @PostMapping("/cadastro")
    private ResponseEntity<Comprador> postCriarComprador(@RequestBody Comprador comprador) {
        Comprador c = service.postCriarComprador(comprador);

        return ResponseEntity.ok(c);
    }

    @GetMapping("/listar/compradores")
    private ResponseEntity<List<Comprador>> getCompradores() {
        List<Comprador> compradores = service.getListarCompradores();

        return ResponseEntity.ok(compradores);
    }

    @GetMapping("/buscar/cadastro/{idComprador}")
    public ResponseEntity<Comprador> getCompradorById(@PathVariable int idComprador){
        Comprador compradorPorId = service.getListaCompradorById(idComprador);

        if (compradorPorId == null){
            //throw new RuntimeException("Erro 404! Cliente não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(compradorPorId);
    }

    @PostMapping("/cadastro/massa/testes")
    public ResponseEntity<List<Comprador>> postCriarVariosCompradores(@RequestBody List<Comprador> listaDeCompradores){
        List<Comprador> compradoresAdicionados = new LinkedList<>();

        for(Comprador comprador : listaDeCompradores) {
            Comprador compradorSalvo = service.postCriarComprador(comprador);
            compradoresAdicionados.add(compradorSalvo);
        }

        return ResponseEntity.ok(compradoresAdicionados);
    }

    @DeleteMapping("/excluir/cadastro/{idComprador}")
    public ResponseEntity<Comprador> deleteExcluirCadastroComprador(@PathVariable Integer idComprador){
        Comprador comprador = service.deleteExcluirCadastroComprador(idComprador);

        return ResponseEntity.ok(comprador);
    }

    @PutMapping("/editar/cadastro/{idComprador}")
    public ResponseEntity<Comprador> putEditarCadastroComprador(@PathVariable Integer idComprador, @RequestBody Comprador compradorAtualizado){
        //captura o comprador pelo id dele:
        Comprador compradorPesquisado = service.getListaCompradorById(idComprador);

        //verificando se o id do comprador é válido:
        if (compradorPesquisado != null) {
               compradorPesquisado.setNome(compradorAtualizado.getNome());
               compradorPesquisado.setSobrenome(compradorAtualizado.getSobrenome());

               //a idade não está elegível para ser editada nesse exemplo
               //compradorPesquisado.setIdade(compradorAtualizado.getIdade());
        }
        else {
            ResponseEntity.notFound().build();
        }

        Comprador comprador = service.putAtualizarDadosComprador(compradorPesquisado);

        return ResponseEntity.ok(compradorPesquisado);
    }

}