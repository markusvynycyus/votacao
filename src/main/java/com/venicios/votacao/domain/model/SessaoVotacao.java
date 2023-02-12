package com.venicios.votacao.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SessaoVotacao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private OffsetDateTime dataAbertura;

    @CreationTimestamp
    private OffsetDateTime dataFechamento;

    @OneToOne
    private Pauta pauta;

    @OneToMany(mappedBy = "sessaoVotacao")
    private List<Voto> votos = new ArrayList<>();




}
