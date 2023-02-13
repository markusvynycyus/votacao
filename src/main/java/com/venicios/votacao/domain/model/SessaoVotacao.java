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
public class SessaoVotacao { // alterando Sessão

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private OffsetDateTime dataAbertura;

    @CreationTimestamp
    private OffsetDateTime dataFechamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Resultado resultado;

    @ManyToOne
    @JoinColumn(name = "pauta_id", nullable = false)
    private Pauta pauta;


    @OneToMany(mappedBy = "sessaoVotacao")
    private List<Voto> votos = new ArrayList<>();



}
