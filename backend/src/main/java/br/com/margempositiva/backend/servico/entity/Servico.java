package br.com.margempositiva.backend.servico.entity;

import br.com.margempositiva.backend.empresa.entity.Empresa;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "valor", nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresaid", nullable = false)
    private Empresa empresa;
}
