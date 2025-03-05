package com.pedidos.service;

import com.pedidos.domain.Comprador;

import java.util.List;

public interface CompradorService {

    //POST
    Comprador postCriarComprador(Comprador comprador);

    //POST
    //Comprador postCriarVariosCompradores(Comprador comprador);

    //GET
    List<Comprador> getListarCompradores();

    //GET
    Comprador getListaCompradorById(int id);

    //DELETE
    Comprador deleteExcluirCadastroComprador(Integer id);

    //PUT
    Comprador putAtualizarDadosComprador(Comprador comprador);
}