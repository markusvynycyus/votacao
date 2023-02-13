package com.venicios.votacao.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Voto {// alerando Voto

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associado_id", nullable = false)
    private Associado associado;

        @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OpcaoVoto opcaoVoto;

    @Column(nullable = false)
    private LocalDateTime dataVoto;

    @ManyToOne
    @JoinColumn(name = "sessao_votacao_id", nullable = false)
    private SessaoVotacao sessaoVotacao;
}
