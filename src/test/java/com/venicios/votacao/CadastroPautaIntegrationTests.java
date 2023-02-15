package com.venicios.votacao;

import com.venicios.votacao.domain.execption.EntidadeEmUsoException;
import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.service.CadastroPautaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDateTime;

@SpringBootTest
class CadastroPautaIntegrationTests {

	@Autowired
	private CadastroPautaService cadastroPautaService;

	@Test
	public void cadastraPauta() {
		Pauta novaPauta = new Pauta();
		novaPauta.setTitulo("Pauta Teste 1");
		novaPauta.setDescricao("Descrição do teste");
		novaPauta.setDataCriacao(LocalDateTime.now());

		novaPauta = cadastroPautaService.salvar(novaPauta);

		assertThat(novaPauta).isNotNull();
		assertThat(novaPauta.getId()).isNotNull();
	}


}
