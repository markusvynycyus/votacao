package com.venicios.votacao.domain.service;

import com.venicios.votacao.domain.execption.AssociadoNaoEncontradoException;
import com.venicios.votacao.domain.execption.EntidadeEmUsoException;
import com.venicios.votacao.domain.model.Associado;
import com.venicios.votacao.domain.repository.AssociadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroAssociadoService {

    private static final String MSG_ASSOCIADO_EM_USO
            = "Associado de código %d não pode ser removido, pois está em uso";


    @Autowired
    private AssociadoRepository associadoRepository;

    @Transactional
    public Associado salvar(Associado associado){
        return associadoRepository.save(associado);

    }

    @Transactional
    public void excluir(Long associadoId) {
        try {
            associadoRepository.deleteById(associadoId);
            associadoRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new AssociadoNaoEncontradoException(associadoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ASSOCIADO_EM_USO, associadoId));
        }
    }

    public Associado buscarOuFalhar(Long associadoId) {
        return associadoRepository.findById(associadoId)
                .orElseThrow(() -> new AssociadoNaoEncontradoException(associadoId));
    }


}
