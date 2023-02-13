package com.venicios.votacao.api.dto.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SessaoVotacaoIdInput {

    @NotNull
    private Long id;
}
