package com.venicios.votacao.api.v1.assembler;

import com.venicios.votacao.api.v1.dto.input.PautaInput;
import com.venicios.votacao.domain.model.Pauta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PautaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Pauta toDomainObject(PautaInput pautaInput){

        return modelMapper.map(pautaInput,Pauta.class);
    }

    public void copyToDomainObject(PautaInput pautaInput, Pauta pauta) {

        modelMapper.map(pautaInput,pauta);
    }
}
