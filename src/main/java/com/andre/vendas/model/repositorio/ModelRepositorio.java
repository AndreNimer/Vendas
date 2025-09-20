package com.andre.vendas.model.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andre.vendas.model.dto.ModelDTO;
import com.andre.vendas.model.entidades.ModelEntidades;

public interface ModelRepositorio extends JpaRepository<ModelEntidades, Long> {

    @Query("SELECT new com.andre.vendas.model.dto.ModelDTO( vendas.vendedorNome, COUNT(vendas.id), SUM(vendas.valor), " +
           "(SUM(vendas.valor) / (COUNT(DISTINCT vendas.dataVenda)))) " +
           "FROM ModelEntidades vendas " +
           "WHERE vendas.dataVenda BETWEEN :dataInicio AND :dataFim " +
           "GROUP BY vendas.vendedorId, vendas.vendedorNome")
    List<ModelDTO> VendasPorPeriodo(
        @Param("dataInicio") LocalDate dataInicio,
        @Param("dataFim") LocalDate dataFim
    );
      
}



