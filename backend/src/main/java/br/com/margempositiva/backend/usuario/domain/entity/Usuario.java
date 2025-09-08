package br.com.margempositiva.backend.usuario.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    @NotEmpty(message = "O campo 'nome' não pode estar vazio.")
    private String nome;
    
    @Email
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "cpf_cnpj", nullable = false, unique = true, length = 18)
    @NotEmpty(message = "O campo 'cpf/cnpj' não pode estar vazio.")
    private String cpfCnpj;
 
    
    @Column(name = "senha")
    @NotEmpty(message = "Senha não pode estar vazia")
    private String senha;

    @Column(name = "telefone", length = 20)
    @NotEmpty(message = "O campo 'telefone' não pode estar vazio.")
    private String telefone;



}
