package com.modulo5.backEnd.controller;

import com.modulo5.backEnd.DTO.ContasAPagarDTO;
import com.modulo5.backEnd.DTO.ContasAPagarRespostaDTO;
import com.modulo5.backEnd.model.ContasAPagarModel;
import com.modulo5.backEnd.enumeration.Status;
import com.modulo5.backEnd.enumeration.Tipo;
import com.modulo5.backEnd.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contasapagar")
public class ContasAPagarController {
    @Autowired
    private ContasAPagarService contasAPagarService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<ContasAPagarRespostaDTO>> buscarTodasContas() {
        return ResponseEntity.ok(contasAPagarService.buscarTodas());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<ContasAPagarModel>> buscarContaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.buscarPorId(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<ContasAPagarModel>> buscarContaPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(contasAPagarService.buscarPorNome(nome));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<ContasAPagarModel>> buscarContaPorStatus(@PathVariable Status status) {
        return ResponseEntity.ok(contasAPagarService.buscarPorStatus(status));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/tipo/{tipo}")
    public ResponseEntity<List<ContasAPagarModel>> buscarContaPorTipo(@PathVariable Tipo tipo) {
        return ResponseEntity.ok(contasAPagarService.buscarPorTipo(tipo));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<ContasAPagarRespostaDTO> cadastrarConta(@Valid @RequestBody ContasAPagarDTO dto) {
        ContasAPagarModel conta = contasAPagarService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(ContasAPagarRespostaDTO.converterParaDTO(conta), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/id/{id}")
    public ResponseEntity<ContasAPagarRespostaDTO> alterarConta(@RequestBody ContasAPagarDTO dto, @PathVariable Long id) {
        ContasAPagarModel conta = contasAPagarService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(ContasAPagarRespostaDTO.converterParaDTO(conta));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<?> deletarConta(@PathVariable Long id) {
        contasAPagarService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
