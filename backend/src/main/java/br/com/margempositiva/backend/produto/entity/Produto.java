package br.com.margempositiva.backend.produto.entity;

import br.com.margempositiva.backend.categoria.entity.Categoria;
import br.com.margempositiva.backend.empresa.entity.Empresa;
import br.com.margempositiva.backend.receitaproduto.entity.ReceitaProduto;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "custofinal", precision = 12, scale = 2)
    private BigDecimal custoFinal;

    @Column(name = "margemlucro", precision = 5, scale = 2)
    private BigDecimal margemLucro;

    @Column(name = "datafabricacao")
    private LocalDate dataFabricacao;

    @Column(name = "valor", nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresaid", nullable = false)
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReceitaProduto> receita = new HashSet<>();
}
