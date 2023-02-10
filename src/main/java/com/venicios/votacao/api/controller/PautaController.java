package com.venicios.votacao.api.controller;

import com.venicios.votacao.api.assembler.PautaModelAssembler;
import com.venicios.votacao.api.dto.PautaDTO;
import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.repository.PautaRepository;
import com.venicios.votacao.domain.service.CadastroPautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/pautas")
public class PautaController {

    @Autowired
    private PautaRepository  pautaRepository;

    @Autowired
    private PautaModelAssembler pautaModelAssembler;

    @Autowired
    private CadastroPautaService cadastroPautaService;

    @GetMapping
    public List<PautaDTO> listar(){
        List<Pauta> pautas = pautaRepository.findAll();
        return pautaModelAssembler.toCollectionModel(pautas);
    }

    @GetMapping("/{pautaId}")
    public PautaDTO buscar(@PathVariable Long pautaId){
        Pauta pauta = cadastroPautaService.buscarOuFalhar(pautaId);
        return pautaModelAssembler.toModel(pauta);

    }


}
