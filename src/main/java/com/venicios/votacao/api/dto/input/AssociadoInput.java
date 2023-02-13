package com.venicios.votacao.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AssociadoInput {


    @NotNull
    private String nome;

    @NotNull
    private String cpf;
}
