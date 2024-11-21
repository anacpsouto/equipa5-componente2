package com.upt.lp.rest_api5.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upt.lp.rest_api5.model.Doacao;
import com.upt.lp.rest_api5.service.DoacaoService;

@RestController
@RequestMapping("/api/doacoes")
public class DoacaoController {

    private final DoacaoService doacaoService;

    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Doacao> registrarPedidoDoacao(
            @RequestParam Long idRequerente,
            @RequestParam Long idDoador,
            @RequestParam Long idEquipamento) {

        Doacao doacao = doacaoService.registrarPedidoDoacao(idRequerente, idDoador, idEquipamento);
        return ResponseEntity.ok(doacao);
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Doacao> finalizarDoacao(@PathVariable Long id) {
        Doacao doacao = doacaoService.finalizarDoacao(id);
        return ResponseEntity.ok(doacao);
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<Doacao> cancelarDoacao(@PathVariable Long id) {
        Doacao doacao = doacaoService.cancelarDoacao(id);
        return ResponseEntity.ok(doacao);
    }
    
}

