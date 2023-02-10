package com.venicios.votacao.domain.execption;

public class PautaNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public PautaNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public PautaNaoEncontradoException(Long pautaId) {
        this(String.format("Não existe um cadastro de Pauta com código %d", pautaId));
    }
}
