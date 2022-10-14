package com.modulo5.backEnd.controller;

import com.modulo5.backEnd.DTO.CidadeDTO;
import com.modulo5.backEnd.DTO.CidadeRespostaDTO;
import com.modulo5.backEnd.model.CidadeModel;
import com.modulo5.backEnd.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cidades")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<CidadeRespostaDTO>> buscarTodasCidades() {
        return ResponseEntity.ok(cidadeService.buscarTodas());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<CidadeModel>> buscarCidadePorId(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<CidadeRespostaDTO> cadastrarCidade(@Valid @RequestBody CidadeDTO dto) {
        CidadeModel cidade = cidadeService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(CidadeRespostaDTO.converterParaDTO(cidade), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/{id}")
    public ResponseEntity<CidadeRespostaDTO> alterarCidade(@RequestBody CidadeDTO dto, @PathVariable Long id) {
        CidadeModel cidade = cidadeService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(CidadeRespostaDTO.converterParaDTO(cidade));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarCidade(@PathVariable Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
