package com.venicios.votacao;


import com.venicios.votacao.domain.execption.EntidadeEmUsoException;
import com.venicios.votacao.domain.execption.PautaNaoEncontradaException;
import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.service.CadastroPautaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CadastroPautaServiceIntegrationTest {

    @Autowired
    private CadastroPautaService cadastroPautaService;

    @Test
    public void testarCadastroPautaSucesso(){
        // cenário
        Pauta novaPauta = new Pauta();
        novaPauta.setDescricao("Titulo Pauta");

        // ação
        novaPauta = cadastroPautaService.salvar(novaPauta);

        // validação
        assertThat(novaPauta).isNotNull();
        assertThat(novaPauta.getId()).isNotNull();
    }

    @Test
    public void testarCadastroPautaSemTitulo() {
        Pauta novaPauta = new Pauta();
        novaPauta.setTitulo(null);

        ConstraintViolationException erroEsperado =
                Assertions.assertThrows(ConstraintViolationException.class, () -> {
                    cadastroPautaService.salvar(novaPauta);
                });

        assertThat(erroEsperado).isNotNull();
    }

    @Test
    public void deveFalhar_QuandoExcluirPautaEmUso() {

        EntidadeEmUsoException erroEsperado =
                Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
                    cadastroPautaService.excluir(1L);
                });

        assertThat(erroEsperado).isNotNull();

    }

    @Test
    public void deveFalhar_QuandoExcluirPautaInexistente() {


        PautaNaoEncontradaException erroEsperado =
                Assertions.assertThrows(PautaNaoEncontradaException.class, () -> {
                    cadastroPautaService.excluir(100L);
                });

        assertThat(erroEsperado).isNotNull();

    }

}
