package br.com.margempositiva.backend.insumo.entity;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "Insumo")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricaoinumo", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "valorcompra", nullable = false, precision = 12, scale = 2)
    private BigDecimal valorCompra;

    @Column(name = "unidade", nullable = false, length = 10)
    private String unidade;
}