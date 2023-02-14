package com.venicios.votacao.api.controller;

import com.venicios.votacao.api.assembler.VotoInputDisassembler;
import com.venicios.votacao.api.assembler.VotoModelAssembler;
import com.venicios.votacao.api.dto.VotoDTO;
import com.venicios.votacao.api.dto.input.VotoInput;
import com.venicios.votacao.domain.execption.EntidadeNaoEncontradaException;
import com.venicios.votacao.domain.execption.NegocioException;
import com.venicios.votacao.domain.model.Voto;
import com.venicios.votacao.domain.repository.VotoRepository;
import com.venicios.votacao.domain.service.EmissaoVotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value= "/votos")
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private VotoModelAssembler votoModelAssembler;

    @Autowired
    private VotoInputDisassembler votoInputDisassembler;

    @Autowired
    private EmissaoVotoService emissaoVotoService;

    @GetMapping
    public List<VotoDTO> listar(){
        List<Voto> votos = votoRepository.findAll();
        return votoModelAssembler.toCollectionModel(votos);
    }

    @GetMapping("/{votoId}")
    public VotoDTO buscar(@PathVariable Long votoId){
        Voto voto = emissaoVotoService.buscarOuFalhar(votoId);
        return votoModelAssembler.toModel(voto);

    }


}
