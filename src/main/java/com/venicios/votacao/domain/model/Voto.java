package com.venicios.votacao.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Voto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associado_id", nullable = false)
    private Associado associado;

    @ManyToOne
    @JoinColumn(name= "sessao_votacao_id", nullable = false)
    private SessaoVotacao sessaoVotacao;

    @Column(nullable = false)
    private Boolean opcaoVoto;

}
