package com.venicios.votacao.domain.execption;

public class VotoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public VotoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public VotoNaoEncontradoException(Long votoId) {
        this(String.format("Não existe um cadastro de Voto com código %d", votoId));
    }
}
