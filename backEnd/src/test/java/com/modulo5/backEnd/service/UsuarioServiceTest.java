package com.modulo5.backEnd.service;

import com.modulo5.backEnd.DTO.UsuarioRespostaDTO;
import com.modulo5.backEnd.model.UsuarioModel;
import com.modulo5.backEnd.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class UsuarioServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializacao() {
        MockitoAnnotations.openMocks(this);
        usuarioModel = new UsuarioModel("João", LocalDate.parse("1998-05-08"), "joao@example.com", "12345678901");
    }

    @Test
    void mostrarTodosUsuarios() {
        Mockito.when(usuarioRepository.findAll()).thenReturn(Collections.emptyList());
        List<UsuarioRespostaDTO> usuarios = usuarioService.buscarTodos();
        Assertions.assertTrue(usuarios.isEmpty());
    }

    @Test
    void testeCadastrarUsuario() {
        Mockito.when(usuarioRepository.existsById(Mockito.anyLong())).thenReturn(false);
        usuarioService.cadastrar(usuarioModel);
        Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuarioModel);
    }

    @Test
    void testeContagemUsuarios() {
        Mockito.when(usuarioRepository.findAll()).thenReturn(List.of(usuarioModel));
        List<UsuarioRespostaDTO> usuarios = usuarioService.buscarTodos();
        Assertions.assertEquals(3, usuarios.size());
    }
}
