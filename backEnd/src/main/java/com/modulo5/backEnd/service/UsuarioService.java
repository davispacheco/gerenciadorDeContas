package com.modulo5.backEnd.service;

import com.modulo5.backEnd.DTO.UsuarioRespostaDTO;
import com.modulo5.backEnd.model.UsuarioModel;
import com.modulo5.backEnd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioRespostaDTO> buscarTodos() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return UsuarioRespostaDTO.converterLista(usuarios);
    }

    public UsuarioModel buscarPorId(Long codigo) {
        Optional<UsuarioModel> obj = usuarioRepository.findById(codigo);
        return obj.get();
    }

    public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alterar(UsuarioModel usuarioModel, Long codigo) {
        UsuarioModel newUsuario = buscarPorId(codigo);
        newUsuario.setNomeUsuario(usuarioModel.getNomeUsuario());
        newUsuario.setEmail(usuarioModel.getEmail());
        return usuarioRepository.save(newUsuario);
    }

    public void deletar(Long codigo) {
        usuarioRepository.deleteById(codigo);
    }
}
