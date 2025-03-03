package com.pedidos.service.impl;

import com.pedidos.domain.Comprador;
import com.pedidos.domain.Endereco;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.repository.EnderecoRepository;
import com.pedidos.service.CompradorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository repository;
    private final EnderecoRepository enderecoRepository;

    private Logger log = LoggerFactory.getLogger(CompradorServiceImpl.class);

    //RequiredArgsConstructor do Lombok criou o construtor automaticamente!
    /* public CompradorServiceImpl(CompradorRepository repository, EnderecoRepository enderecoRepository) {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
    }*/

    @Override
    public Comprador postCriarComprador(Comprador comprador) {
        if (Objects.nonNull(comprador.getEnderecos()) && !comprador.getEnderecos().isEmpty()) {
            List<Endereco> enderecos = enderecoRepository.saveAll(comprador.getEnderecos());
            log.info("");
        }
        Comprador c = repository.save(comprador);
        log.info("");
        return c;
    }

    @Override
    public List<Comprador> getListarCompradores() {
        return repository.findAll();
    }

    //listar comprador único por id - Desafio
    @Override
    public Comprador getListaCompradorById(int id) {
        return repository.findById(id).orElse(null);
    }


}