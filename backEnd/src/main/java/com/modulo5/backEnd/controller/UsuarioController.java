package com.modulo5.backEnd.controller;

import com.modulo5.backEnd.DTO.UsuarioDTO;
import com.modulo5.backEnd.DTO.UsuarioRespostaDTO;
import com.modulo5.backEnd.model.UsuarioModel;
import com.modulo5.backEnd.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<UsuarioRespostaDTO>> buscarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<UsuarioModel>> buscarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<UsuarioRespostaDTO> cadastrarUsuario(@Valid @RequestBody UsuarioDTO dto) {
        UsuarioModel usuario = usuarioService.cadastrar(dto.converterParaObjeto());
        return new ResponseEntity<>(UsuarioRespostaDTO.converterParaDTO(usuario), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/id/{id}")
    public ResponseEntity<UsuarioRespostaDTO> alterarUsuario(@RequestBody UsuarioDTO dto, @PathVariable Long id) {
        UsuarioModel usuario = usuarioService.alterar(dto.converterParaObjeto());
        return ResponseEntity.ok(UsuarioRespostaDTO.converterParaDTO(usuario));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
