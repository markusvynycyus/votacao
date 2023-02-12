package com.venicios.votacao.api.dto;


import com.venicios.votacao.domain.model.Voto;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SessaoVotacaoDTO {

    private Long id;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFechamento;
    private PautaDTO pauta;
    private List<VotoDTO> votos;
}
