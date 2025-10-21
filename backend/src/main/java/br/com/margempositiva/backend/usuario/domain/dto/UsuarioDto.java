package br.com.margempositiva.backend.usuario.domain.dto;

import br.com.margempositiva.backend.usuario.domain.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private String cpfCnpj;
    private String telefone;
    private UserRole role;

}