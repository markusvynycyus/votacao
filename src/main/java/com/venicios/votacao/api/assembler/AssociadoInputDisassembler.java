package com.venicios.votacao.api.assembler;

import com.venicios.votacao.api.dto.input.AssociadoInput;
import com.venicios.votacao.domain.model.Associado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssociadoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Associado toDomainObject(AssociadoInput associadoInput){
        return modelMapper.map(associadoInput,Associado.class);
    }

    public void copyToDomainObject(AssociadoInput associadoInput, Associado associado) {
        modelMapper.map(associadoInput,associado);
    }
}


