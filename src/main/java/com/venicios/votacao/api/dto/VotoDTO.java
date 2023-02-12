package com.venicios.votacao.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoDTO {

    private Long id;
    private AssociadoDTO associado;
    private SessaoVotacaoDTO sessaoVotacao;
    private Boolean opcaoVoto;

}
