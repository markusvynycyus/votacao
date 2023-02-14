package com.venicios.votacao.domain.execption;

public class PautaNaoEncontradaException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public PautaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public PautaNaoEncontradaException(Long pautaId) {
        this(String.format("Não existe um cadastro de Pauta com código %d", pautaId));
    }
}