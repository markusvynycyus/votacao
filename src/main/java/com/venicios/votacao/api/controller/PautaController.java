package com.venicios.votacao.api.controller;

import com.venicios.votacao.api.assembler.PautaInputDissasembler;
import com.venicios.votacao.api.assembler.PautaModelAssembler;
import com.venicios.votacao.api.dto.PautaDTO;
import com.venicios.votacao.api.dto.input.PautaInput;
import com.venicios.votacao.domain.model.Pauta;
import com.venicios.votacao.domain.repository.PautaRepository;
import com.venicios.votacao.domain.service.CadastroPautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private PautaInputDissasembler pautaInputDissasembler;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PautaDTO adicionar(@RequestBody @Valid PautaInput pautaInput){
        Pauta pauta = pautaInputDissasembler.toDomainObject(pautaInput);

        pauta= cadastroPautaService.salvar(pauta);

        return pautaModelAssembler.toModel(pauta);

    }

    @PutMapping("/{pautaId}")
    public PautaDTO atualizar(@PathVariable Long pautaId,
                                 @RequestBody @Valid PautaInput pautaInput) {
        Pauta pautaAtual = cadastroPautaService.buscarOuFalhar(pautaId);

        pautaInputDissasembler.copyToDomainObject(pautaInput, pautaAtual);

        pautaAtual = cadastroPautaService.salvar(pautaAtual);

        return pautaModelAssembler.toModel(pautaAtual);
    }

    @DeleteMapping("/{pautaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long pautaId) {
        cadastroPautaService.excluir(pautaId);
    }
}
