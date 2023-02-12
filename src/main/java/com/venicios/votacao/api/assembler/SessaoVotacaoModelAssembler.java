package com.venicios.votacao.api.assembler;

import com.venicios.votacao.api.dto.SessaoVotacaoDTO;
import com.venicios.votacao.domain.model.SessaoVotacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SessaoVotacaoModelAssembler {

    @Autowired
    public ModelMapper modelMapper;

    public SessaoVotacaoDTO toModel (SessaoVotacao sessaoVotacao){
        return modelMapper.map(sessaoVotacao, SessaoVotacaoDTO.class);
    }

    public List<SessaoVotacaoDTO> toCollectionModel(List<SessaoVotacao> sessaoVotacaos){
        return sessaoVotacaos.stream()
                .map(sessaoVotacao -> toModel(sessaoVotacao))
                .collect(Collectors.toList());
    }

}
