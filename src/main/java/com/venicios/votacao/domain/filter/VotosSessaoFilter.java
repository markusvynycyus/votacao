package com.venicios.votacao.domain.filter;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import java.time.OffsetDateTime;

@Getter
@Setter
public class VotosSessaoFilter {

    private Long sessaoId;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private OffsetDateTime dataAbertura;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private OffsetDateTime dataFechamento;
}
