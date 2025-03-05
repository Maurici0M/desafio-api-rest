package com.pedidos.service.impl;

import com.pedidos.domain.Comprador;
import com.pedidos.domain.Endereco;
import com.pedidos.repository.CompradorRepository;
import com.pedidos.repository.EnderecoRepository;
import com.pedidos.service.CompradorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CompradorServiceImpl implements CompradorService {

    private final CompradorRepository compradorRepository;
    private final EnderecoRepository enderecoRepository;
    private final Logger log = LoggerFactory.getLogger(CompradorServiceImpl.class);

    //RequiredArgsConstructor do Lombok criou o construtor automaticamente!

    @Override
    public Comprador postCriarComprador(Comprador comprador) {
        if (Objects.nonNull(comprador.getEnderecos()) && !comprador.getEnderecos().isEmpty()) {
            List<Endereco> enderecos = enderecoRepository.saveAll(comprador.getEnderecos());
            log.info("");
        }
        Comprador c = compradorRepository.save(comprador);
        log.info("");
        return c;
    }

    @Deprecated
    public Comprador postCriarVariosCompradores(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    @Override
    public List<Comprador> getListarCompradores() {
        return compradorRepository.findAll();
    }

    @Override
    public Comprador getListaCompradorById(int id) {
        return compradorRepository.findById(id).orElse(null);
    }

    @Override
    public Comprador deleteExcluirCadastroComprador(Integer id) {
        Comprador compradorQueSeraExcluido = compradorRepository.findById(id).orElse(null);
        compradorRepository.deleteById(id);

        return compradorQueSeraExcluido;
    }

    public Comprador putAtualizarDadosComprador(Comprador comprador){
        return compradorRepository.save(comprador);
    }

}