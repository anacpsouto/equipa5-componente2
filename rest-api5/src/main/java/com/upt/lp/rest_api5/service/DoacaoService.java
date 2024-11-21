package com.upt.lp.rest_api5.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.upt.lp.rest_api5.model.Doacao;
import com.upt.lp.rest_api5.repository.DoacaoRepository;

@Service
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;

    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    public Doacao registrarPedidoDoacao(Long idRequerente, Long idDoador, Long idEquipamento) {
        Doacao doacao = new Doacao();
        doacao.setDataInicio(LocalDate.now());
        doacao.setEstadoDoacao("PENDENTE");
        doacao.setIdRequerente(idRequerente);
        doacao.setIdDoador(idDoador);
        doacao.setIdEquipamento(idEquipamento);

        return doacaoRepository.save(doacao);
    }

    public Doacao finalizarDoacao(Long id) {
        Doacao doacao = doacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doação não encontrada"));

        doacao.setEstadoDoacao("TERMINADA");
        doacao.setDataFim(LocalDate.now());

        return doacaoRepository.save(doacao);
    }

    public Doacao cancelarDoacao(Long id) {
        Doacao doacao = doacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doação não encontrada"));

        doacao.setEstadoDoacao("CANCELADA");
        doacao.setDataFim(LocalDate.now());

        return doacaoRepository.save(doacao);
    }
    
}

