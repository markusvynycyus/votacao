package com.venicios.votacao.api.v1.assembler;

import com.venicios.votacao.api.v1.dto.input.VotoInput;
import com.venicios.votacao.domain.model.Voto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VotoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Voto toDomainObject(VotoInput votoInput){
        return modelMapper.map(votoInput,Voto.class);
    }

    public void copyToDomainObject(VotoInput votoInput, Voto voto) {
        modelMapper.map(votoInput,voto);
    }
}
