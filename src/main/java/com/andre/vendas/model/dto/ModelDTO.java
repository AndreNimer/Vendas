package com.andre.vendas.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO {
    private String nome;
    private Long totalVendas;
    private BigDecimal valorTotalVendas;
    private BigDecimal mediaDiariaVendas;
}

