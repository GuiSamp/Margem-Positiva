package br.com.margempositiva.backend.receitaproduto.entity;
import java.math.BigDecimal;

import br.com.margempositiva.backend.insumo.entity.Insumo;
import br.com.margempositiva.backend.produto.entity.Produto;
import jakarta.persistence.*;

@Entity
@Table(name = "ReceitaProduto")
public class ReceitaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreceita")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtoid", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insumoid", nullable = false)
    private Insumo insumo;

    @Column(name = "quantidadeinsumo", nullable = false, precision = 12, scale = 3)
    private BigDecimal quantidadeInsumo;

    @Column(name = "custototal", nullable = false, precision = 12, scale = 2)
    private BigDecimal custoTotal;

}