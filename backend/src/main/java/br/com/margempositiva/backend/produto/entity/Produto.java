package br.com.margempositiva.backend.produto.entity;

import br.com.margempositiva.backend.categoria.entity.Categoria;
import br.com.margempositiva.backend.empresa.entity.Empresa;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
}
