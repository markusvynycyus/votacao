package com.venicios.votacao.api.v1.assembler;

import com.venicios.votacao.api.v1.dto.PautaDTO;
import com.venicios.votacao.domain.model.Pauta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PautaModelAssembler {

    @Autowired
    public ModelMapper modelMapper;

    public PautaDTO toModel (Pauta pauta){
        return modelMapper.map(pauta, PautaDTO.class);
    }

    public List<PautaDTO> toCollectionModel(List<Pauta> pautas){
            return pautas.stream()
                    .map(pauta -> toModel(pauta))
                    .collect(Collectors.toList());
    }

}
