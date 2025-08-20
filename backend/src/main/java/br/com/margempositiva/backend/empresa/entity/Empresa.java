package br.com.margempositiva.backend.empresa.entity;

import br.com.margempositiva.backend.categoria.entity.Categoria;
import br.com.margempositiva.backend.produto.entity.Produto;
import br.com.margempositiva.backend.servico.entity.Servico;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "RazaoSocial", nullable = false, length = 255)
    private String razaoSocial;

    @Column(name = "CNPJ", nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "Telefone", length = 20)
    private String telefone;

    @Column(name = "Email", unique = true, length = 255)
    private String email;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Produto> produtos = new ArrayList<>();

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Servico> servicos = new ArrayList<>();

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Categoria> categorias = new ArrayList<>();
}
