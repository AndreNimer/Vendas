package com.andre.vendas.service;

import com.andre.vendas.model.dto.ModelDTO;
import com.andre.vendas.model.entidades.ModelEntidades;
import com.andre.vendas.model.repositorio.ModelRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class VendaServico {

    @Autowired
    private ModelRepositorio repositorioVendas;

    public ModelEntidades criarVenda(ModelEntidades venda) {
        return repositorioVendas.save(venda);
    }

    public List<ModelDTO> ResumoVendas(LocalDate dataInicio, LocalDate dataFim) {
        return repositorioVendas.VendasPorPeriodo(dataInicio, dataFim);
    }
}
