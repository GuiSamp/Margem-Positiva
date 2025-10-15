package br.com.margempositiva.backend.usuario.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UsuarioCreateRequestDto {

    @NotNull(message = "Nome não pode estar vazio")
    private String nome;

    @NotNull(message = "Email não pode estar vazio")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotNull(message = "O campo 'cpf/cnpj' não pode estar vazio.")
    private String cpfCnpj;

    @NotNull(message = "Senha não pode estar vazia")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;

    @NotNull(message = "Telefone não pode estar vazio")
    private String telefone;
}