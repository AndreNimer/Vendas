package com.andre.vendas.controller;

import com.andre.vendas.model.dto.ModelDTO;
import com.andre.vendas.model.entidades.ModelEntidades;
import com.andre.vendas.service.VendaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaServico vendaServico;

    @PostMapping
    public ResponseEntity<ModelEntidades> criarVenda(@RequestBody ModelEntidades venda) {
        ModelEntidades novaVenda = vendaServico.criarVenda(venda);
        return ResponseEntity.ok(novaVenda);
    }

    @GetMapping("/resumo-vendedores")
    public ResponseEntity<List<ModelDTO>> VendasPorPeriodo(
            @RequestParam(value = "dataInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(value = "dataFim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        
            if (dataFim == null) {
                dataFim = dataInicio;
            }
            else {
                if(dataInicio == null){
                    dataInicio = dataFim;
            }}


        
            List<ModelDTO> resumo = vendaServico.ResumoVendas(dataInicio, dataFim);
        return ResponseEntity.ok(resumo);
    }
}
