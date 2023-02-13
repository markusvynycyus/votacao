package com.venicios.votacao.api.controller;

import com.venicios.votacao.api.assembler.SessaoVotacaoModelAssembler;
import com.venicios.votacao.api.dto.SessaoVotacaoDTO;
import com.venicios.votacao.domain.model.SessaoVotacao;
import com.venicios.votacao.domain.repository.SessaoVotacaoRepository;
import com.venicios.votacao.domain.service.CadastroSessaoVotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private SessaoVotacaoModelAssembler sessaoVotacaoModelAssembler;

    @Autowired
    private CadastroSessaoVotacaoService cadastroSessaoVotacaoService;

    @GetMapping
    public List<SessaoVotacaoDTO> listar(){
        List<SessaoVotacao> sessaoVotacaos = sessaoVotacaoRepository.findAll();
        return sessaoVotacaoModelAssembler.toCollectionModel(sessaoVotacaos);
    }

    @GetMapping("/{sessaoVotacaoId}")
    public SessaoVotacaoDTO buscar(@PathVariable Long sessaoVotacaoId){
        SessaoVotacao sessaoVotacao = cadastroSessaoVotacaoService.buscarOuFalhar(sessaoVotacaoId);
        return sessaoVotacaoModelAssembler.toModel(sessaoVotacao);

    }

}
