package br.edu.ifrn.servico_veiculos.service;

import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository){
        this.repository = repository;
    }
}
