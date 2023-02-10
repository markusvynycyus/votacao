package com.venicios.votacao.domain.service;

import com.venicios.votacao.domain.execption.VotoNaoEncontradoException;
import com.venicios.votacao.domain.model.Voto;
import com.venicios.votacao.domain.repository.VotoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroVotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Transactional
    public Voto salvar(Voto voto){
        return votoRepository.save(voto);
    }


    public Voto buscarOuFalhar(Long votoId) {
        return votoRepository.findById(votoId)
                .orElseThrow(() -> new VotoNaoEncontradoException(votoId));
    }
}
