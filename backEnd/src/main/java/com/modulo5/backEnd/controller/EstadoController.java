package com.modulo5.backEnd.controller;

import com.modulo5.backEnd.DTO.EstadoDTO;
import com.modulo5.backEnd.DTO.EstadoRespostaDTO;
import com.modulo5.backEnd.model.EstadoModel;
import com.modulo5.backEnd.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estados")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<EstadoRespostaDTO>> buscarTodosEstados() {
        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<EstadoModel> buscarEstadoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.buscarPorId(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<EstadoRespostaDTO> cadastrarEstado(@Valid @RequestBody EstadoDTO dto) {
        EstadoModel estado = estadoService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(EstadoRespostaDTO.converterParaDTO(estado), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/id/{id}")
    public ResponseEntity<EstadoRespostaDTO> alterarEstado(@RequestBody EstadoDTO dto, @PathVariable Long id) {
        EstadoModel estado = estadoService.alterar(dto.converterParaObjeto(), id);
        return ResponseEntity.ok(EstadoRespostaDTO.converterParaDTO(estado));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<?> deletarEstado(@PathVariable Long id) {
        estadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
