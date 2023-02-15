package com.venicios.votacao.api.v1.assembler;

import com.venicios.votacao.api.v1.dto.VotoDTO;
import com.venicios.votacao.domain.model.Voto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VotoModelAssembler {

    @Autowired
    public ModelMapper modelMapper;

    public VotoDTO toModel (Voto voto){
        return modelMapper.map(voto, VotoDTO.class);
    }

    public List<VotoDTO> toCollectionModel(List<Voto> votos){
        return votos.stream()
                .map(voto -> toModel(voto))
                .collect(Collectors.toList());
    }

}
