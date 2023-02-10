package com.venicios.votacao.api.controller;


import com.venicios.votacao.api.assembler.AssociadoModelAssembler;
import com.venicios.votacao.api.dto.AssociadoDTO;
import com.venicios.votacao.domain.model.Associado;
import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.repository.AssociadoRepository;
import com.venicios.votacao.domain.service.CadastroAssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/associados")
public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private AssociadoModelAssembler associadoModelAssembler;

    @Autowired
    private CadastroAssociadoService cadastroAssociadoService;

    @GetMapping
    public List<AssociadoDTO> listar(){
        List<Associado> associados = associadoRepository.findAll();
        return associadoModelAssembler.toCollectionModel(associados);

    }

    @GetMapping("/{associadoId}")
    public AssociadoDTO buscar (@PathVariable Long associadoId){
        Associado associado = cadastroAssociadoService.buscarOuFalhar(associadoId);
        return associadoModelAssembler.toModel(associado);

    }

}
