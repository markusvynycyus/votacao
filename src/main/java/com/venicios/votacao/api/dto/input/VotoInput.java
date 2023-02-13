package com.venicios.votacao.api.dto.input;

import com.venicios.votacao.domain.model.SessaoVotacao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VotoInput {

    @Valid
    @NotNull
    private AssociadoIdInput associado;

    @Valid
    @NotNull
    private SessaoVotacaoIdInput sessao;



}
