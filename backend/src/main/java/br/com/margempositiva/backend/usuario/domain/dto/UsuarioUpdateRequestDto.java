package br.com.margempositiva.backend.usuario.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UsuarioUpdateRequestDto {

    @NotNull(message = "Nome não pode estar vazio")
    private String nome;

    @NotNull(message = "Telefone não pode estar vazio")
    private String telefone;
}