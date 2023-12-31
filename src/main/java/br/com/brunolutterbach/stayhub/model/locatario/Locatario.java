package br.com.brunolutterbach.stayhub.model.locatario;

import br.com.brunolutterbach.stayhub.model.carteira.Carteira;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "usuarios")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    private String email;
    private LocalDateTime dataRegistro = LocalDateTime.now();
    @OneToOne(cascade = CascadeType.ALL) // CascadeType.ALL -> se eu apagar o usuario, apaga a carteira
    private Carteira carteira;

    public Locatario(DadosCadastroLocatario dados) {
        this.nome = dados.nome();
        this.senha = dados.senha();
        this.email = dados.email();
        this.carteira = new Carteira();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Locatario usuario = (Locatario) o;
        return getId() != null && Objects.equals(getId(), usuario.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public void atualizar(DadosAtualizacaoLocatario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
    }
}
