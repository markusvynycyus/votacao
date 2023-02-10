package com.venicios.votacao.api.assembler;

import com.venicios.votacao.api.dto.AssociadoDTO;
import com.venicios.votacao.domain.model.Associado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssociadoModelAssembler {

    @Autowired
    public ModelMapper modelMapper;

    public AssociadoDTO toModel (Associado associado){
        return modelMapper.map(associado, AssociadoDTO.class);
    }

    public List<AssociadoDTO> toCollectionModel(List<Associado> associados){
        return associados.stream()
                .map(associado -> toModel(associado))
                .collect(Collectors.toList());
    }

}
