package com.venicios.votacao.domain.service;

import com.venicios.votacao.domain.execption.VotoNaoEncontradoException;
import com.venicios.votacao.domain.model.Voto;
import com.venicios.votacao.domain.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmissaoVotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private CadastroSessaoVotacaoService cadastroSessaoVotacaoService;

    @Autowired
    private CadastroAssociadoService  cadastroAssociadoService;

    // implementar o meto de salvar voto .

    public Voto buscarOuFalhar(Long votoId) {
        return votoRepository.findById(votoId)
                .orElseThrow(() -> new VotoNaoEncontradoException(votoId));
    }
}
