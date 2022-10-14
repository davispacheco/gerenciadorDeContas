package com.modulo5.backEnd.controller;

import com.modulo5.backEnd.DTO.EnderecoDTO;
import com.modulo5.backEnd.DTO.EnderecoRespostaDTO;
import com.modulo5.backEnd.model.EnderecoModel;
import com.modulo5.backEnd.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<EnderecoRespostaDTO>> buscarTodosEnderecos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<EnderecoModel> buscarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<EnderecoRespostaDTO> cadastrarEndereco(@Valid @RequestBody EnderecoDTO dto) {
        EnderecoModel endereco = enderecoService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(EnderecoRespostaDTO.converterParaDTO(endereco), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/id/{id}")
    public ResponseEntity<EnderecoRespostaDTO> alterarEndereco(@RequestBody EnderecoDTO dto, @PathVariable Long id) {
        EnderecoModel endereco = enderecoService.alterar(dto.converterParaObjeto(), id);
        return ResponseEntity.ok(EnderecoRespostaDTO.converterParaDTO(endereco));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
