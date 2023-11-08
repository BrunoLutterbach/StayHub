package br.com.brunolutterbach.stayhub.model.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @NotBlank
        String email,
        @NotNull
        TipoUsuario tipoUsuario

) {
}
