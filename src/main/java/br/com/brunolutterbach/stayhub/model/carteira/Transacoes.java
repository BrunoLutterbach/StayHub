package br.com.brunolutterbach.stayhub.model.carteira;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "transacoes")
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataTransacao;
    private BigDecimal valor;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Carteira carteira;
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;
    @Enumerated(EnumType.STRING)
    private TipoSubTransacao tipoSubTransacao;

}
