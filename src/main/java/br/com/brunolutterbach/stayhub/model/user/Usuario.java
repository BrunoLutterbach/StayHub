package br.com.brunolutterbach.stayhub.model.user;

import br.com.brunolutterbach.stayhub.model.carteira.Carteira;

import javax.persistence.*;

@Entity(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @OneToOne(cascade = CascadeType.ALL) // CascadeType.ALL -> se eu apagar o usuario, apaga a carteira
    private Carteira carteira;

}
