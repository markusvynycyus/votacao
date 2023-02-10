package com.venicios.votacao.domain.service;

import com.venicios.votacao.domain.execption.AssociadoNaoEncontradoException;
import com.venicios.votacao.domain.model.Associado;
import com.venicios.votacao.domain.repository.AssociadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroAssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Transactional
    public Associado salvar(Associado associado){
        return associadoRepository.save(associado);

    }

    public Associado buscarOuFalhar(Long associadoId) {
        return associadoRepository.findById(associadoId)
                .orElseThrow(() -> new AssociadoNaoEncontradoException(associadoId));
    }



}
