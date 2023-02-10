package com.venicios.votacao.domain.execption;

public class AssociadoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public AssociadoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public AssociadoNaoEncontradoException(Long associadoId) {
        this(String.format("Não existe um cadastro de Associado com código %d", associadoId));
    }
}
