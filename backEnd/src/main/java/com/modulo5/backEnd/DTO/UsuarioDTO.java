package com.modulo5.backEnd.DTO;

import com.modulo5.backEnd.model.UsuarioModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO {
    @NotBlank(message = "Nome do usuário deve ser preenchido.")
    @Length(min = 4, max = 20, message = "Nome do usuário deve possuir de {min} a {max} caracteres.")
    private String nomeUsuario;

    @NotNull(message = "Data de nascimento deve ser preenchida.")
    private LocalDate dataNascimento;

    @NotBlank(message = "E-mail deve ser preenchido.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotBlank(message = "CPF deve ser preenchido.")
    @CPF(message = "CPF inválido.")
    private String cpf;

    public UsuarioModel converterParaObjeto() {
        return new UsuarioModel(nomeUsuario, dataNascimento, email, cpf);
    }
}
