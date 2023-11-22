package br.com.brunolutterbach.stayhub.model.imovel;

import br.com.brunolutterbach.stayhub.model.user.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "imoveis")
@Data
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
    private boolean ativo = false;
    @ElementCollection
    private List<String> fotos;
    private BigDecimal valor = BigDecimal.ZERO;
    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisponibilidadeImovel> disponibilidades = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietario_id")
    private Usuario proprietario;

    public Imovel(DadosCadastroImovel dados) {
        this.nome = dados.nome();
        this.endereco = dados.endereco();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
        this.categoria = dados.categoriaImovel();
        this.descricao = dados.descricao();
        this.fotos = dados.fotos();
        this.valor = dados.valor();
    }

    public Imovel() {

    }

    public void adicionarDisponibilidade(LocalDate dataInicio, LocalDate dataFim) {
        DisponibilidadeImovel disponibilidade = new DisponibilidadeImovel(this, dataInicio, dataFim);
        disponibilidades.add(disponibilidade);
    }

    public boolean checarDisponibilidade(LocalDate dataInicio, LocalDate dataFim) {
        return disponibilidades.stream()
                .anyMatch(data -> data.getDataInicio().isBefore(dataFim) &&
                        data.getDataFim().isAfter(dataInicio));
    }

    public void atualizar(DadosAtualizacaoImovel dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco = dados.endereco();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
    }
}