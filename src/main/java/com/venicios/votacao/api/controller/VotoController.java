package com.venicios.votacao.api.controller;

import com.venicios.votacao.api.assembler.VotoModelAssembler;
import com.venicios.votacao.api.dto.VotoDTO;
import com.venicios.votacao.domain.model.Voto;
import com.venicios.votacao.domain.repository.VotoRepository;
import com.venicios.votacao.domain.service.CadastroVotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/votos")
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private VotoModelAssembler votoModelAssembler;

    @Autowired
    private CadastroVotoService cadastroVotoService;

    @GetMapping
    public List<VotoDTO> listar(){
        List<Voto> votos = votoRepository.findAll();
        return votoModelAssembler.toCollectionModel(votos);
    }

    @GetMapping("/{votoId}")
    public VotoDTO buscar(@PathVariable Long votoId){
        Voto voto = cadastroVotoService.buscarOuFalhar(votoId);
        return votoModelAssembler.toModel(voto);

    }

}
