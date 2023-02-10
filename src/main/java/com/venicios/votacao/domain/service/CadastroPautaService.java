package com.venicios.votacao.domain.service;


import com.venicios.votacao.domain.execption.PautaNaoEncontradoException;
import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.repository.PautaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPautaService {

    @Autowired
    private PautaRepository pautaRepository;

    @Transactional
    public Pauta salvar(Pauta pauta ){
        return pautaRepository.save(pauta);
    }

    public Pauta buscarOuFalhar(Long pautaId) {
        return pautaRepository.findById(pautaId)
                .orElseThrow(() -> new PautaNaoEncontradoException(pautaId));
    }




}
