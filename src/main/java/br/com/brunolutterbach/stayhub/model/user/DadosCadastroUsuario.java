package br.com.brunolutterbach.stayhub.model.user;

import javax.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @NotBlank
        String email,
        @NotBlank
        TipoUsuario tipoUsuario

) {
}
