package com.venicios.votacao.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        return modelMapper;
    }



}
