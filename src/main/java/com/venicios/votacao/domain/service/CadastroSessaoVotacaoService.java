package com.venicios.votacao.domain.service;

import com.venicios.votacao.domain.execption.SessaoVotacaoNaoEncontradoException;
import com.venicios.votacao.domain.model.SessaoVotacao;
import com.venicios.votacao.domain.repository.SessaoVotacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroSessaoVotacaoService {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Transactional
    public SessaoVotacao salvar(SessaoVotacao sessaoVotacao){
        return sessaoVotacaoRepository.save(sessaoVotacao);
    }


    public SessaoVotacao buscarOuFalhar(Long sessaoId) {
        return sessaoVotacaoRepository.findById(sessaoId)
                .orElseThrow(() -> new SessaoVotacaoNaoEncontradoException(sessaoId));
    }

}
