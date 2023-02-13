package com.venicios.votacao.domain.service;

import com.venicios.votacao.domain.execption.VotoNaoEncontradoException;
import com.venicios.votacao.domain.model.Associado;
import com.venicios.votacao.domain.model.SessaoVotacao;
import com.venicios.votacao.domain.model.Voto;
import com.venicios.votacao.domain.repository.VotoRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Voto validarVoto(Voto voto){

        Long associadoId = voto.getAssociado().getId();
        Associado associado = cadastroAssociadoService.buscarOuFalhar(associadoId);
        voto.setAssociado(associado);

        Long sessaoVotacaoId = voto.getSessaoVotacao().getId();
        SessaoVotacao sessaoVotacao = cadastroSessaoVotacaoService.buscarOuFalhar(sessaoVotacaoId);
        voto.setSessaoVotacao(sessaoVotacao);

        return votoRepository.save(voto);

    }

    public Voto buscarOuFalhar(Long votoId) {
        return votoRepository.findById(votoId)
                .orElseThrow(() -> new VotoNaoEncontradoException(votoId));
    }
}
