package com.venicios.votacao.api.controller;


import com.venicios.votacao.api.assembler.AssociadoInputDisassembler;
import com.venicios.votacao.api.assembler.AssociadoModelAssembler;
import com.venicios.votacao.api.dto.AssociadoDTO;
import com.venicios.votacao.api.dto.input.AssociadoInput;
import com.venicios.votacao.domain.model.Associado;
import com.venicios.votacao.domain.repository.AssociadoRepository;
import com.venicios.votacao.domain.service.CadastroAssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private AssociadoInputDisassembler associadoInputDisassembler;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssociadoDTO adicionar(@RequestBody @Valid AssociadoInput associadoInput){
        Associado associado = associadoInputDisassembler.toDomainObject(associadoInput);

        associado= cadastroAssociadoService.salvar(associado);

        return associadoModelAssembler.toModel(associado);

    }

    @PutMapping("/{associadoId}")
    public AssociadoDTO atualizar(@PathVariable Long associadoId,
                              @RequestBody @Valid AssociadoInput associadoInput) {
        Associado associadoAtual = cadastroAssociadoService.buscarOuFalhar(associadoId);

        associadoInputDisassembler.copyToDomainObject(associadoInput, associadoAtual);

        associadoAtual = cadastroAssociadoService.salvar(associadoAtual);

        return associadoModelAssembler.toModel(associadoAtual);
    }

    @DeleteMapping("/{associadoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long associadoId) {
        cadastroAssociadoService.excluir(associadoId);
    }



}
