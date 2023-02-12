package com.venicios.votacao.domain.service;

import com.venicios.votacao.domain.execption.EntidadeEmUsoException;
import com.venicios.votacao.domain.execption.PautaNaoEncontradoException;
import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.repository.PautaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroPautaService {

    private static final String MSG_PAUTA_EM_USO
            = "Pauta de código %d não pode ser removida, pois está em uso";

    @Autowired
    private PautaRepository pautaRepository;

    @Transactional
    public Pauta salvar(Pauta pauta ){
        return pautaRepository.save(pauta);
    }

    @Transactional
    public void excluir(Long pautaId) {
        try {
            pautaRepository.deleteById(pautaId);
            pautaRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new PautaNaoEncontradoException(pautaId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_PAUTA_EM_USO, pautaId));
        }
    }


    public Pauta buscarOuFalhar(Long pautaId) {
        return pautaRepository.findById(pautaId)
                .orElseThrow(() -> new PautaNaoEncontradoException(pautaId));
    }

}
