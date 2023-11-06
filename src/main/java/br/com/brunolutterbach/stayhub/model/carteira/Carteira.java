package br.com.brunolutterbach.stayhub.model.carteira;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "carteiras")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal saldo;
    @OneToMany(mappedBy = "carteira")
    private List<Transacoes> transacoes;

}
