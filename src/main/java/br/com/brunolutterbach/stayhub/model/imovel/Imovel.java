package br.com.brunolutterbach.stayhub.model.imovel;

import br.com.brunolutterbach.stayhub.model.user.Usuario;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "imoveis")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String cidade;
    private UnidadeFederacao uf;
    private String cep;
    private CategoriaImovel categoria;
    private String descricao;
    @ElementCollection
    private List<String> fotos;
    private BigDecimal valor = BigDecimal.ZERO;
    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisponibilidadeImovel> disponibilidades = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietario_id")
    private Usuario proprietario;


}