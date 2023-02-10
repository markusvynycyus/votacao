package com.venicios.votacao.domain.execption;

public class SessaoVotacaoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public SessaoVotacaoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public SessaoVotacaoNaoEncontradoException(Long sessaoId) {
        this(String.format("Não existe um cadastro de SessaoVotacao com código %d", sessaoId));
    }
}
