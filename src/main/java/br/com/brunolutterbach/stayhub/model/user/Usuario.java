package br.com.brunolutterbach.stayhub.model.user;

import javax.persistence.*;

@Entity(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

}
