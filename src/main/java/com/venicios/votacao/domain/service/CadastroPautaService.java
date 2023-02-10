package com.venicios.votacao.domain.service;


import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPautaService {

    @Autowired
    private PautaRepository pautaRepository;

    public Pauta salvar(Pauta pauta ){
        return pautaRepository.save(pauta);

    }
}
