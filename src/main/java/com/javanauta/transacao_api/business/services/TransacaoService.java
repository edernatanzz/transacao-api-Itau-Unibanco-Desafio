package com.javanauta.transacao_api.business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javanauta.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.javanauta.transacao_api.infrastructure.exceptions.UnprocessableEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTrasacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto){

        log.info("iniciado o processamento de iniciar transações" + dto);
        
        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maiores que a data atual");
            throw new UnprocessableEntity("Data e hora maiores que a data e horas atuais");
        }
        if(dto.valor() < 0){
            log.error("Valor não pode ser maior que 0");
            throw new UnprocessableEntity("Valor não pode ser maior que 0");
        }

        listaTrasacoes.add(dto);
        log.info("Transacoes adicionadas com sucesso" );
    }

    public void limparTransacoes(){
        log.info("Inciado processamento para delatar transações");
        listaTrasacoes.clear();
        log.info("Inciado deletadas com sucesso");

    }

    public List<TransacaoRequestDTO> buscaTransacoes (Integer intervaloBusca){
        log.info("Inciado buscas de transações por tempo "+ intervaloBusca );
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
        log.info("Retorno de transações com sucesso !");
        return listaTrasacoes.stream()
            .filter(transacao -> transacao.dataHora()
            .isAfter(dataHoraIntervalo)).toList();

    }



}
