package br.com.brunolutterbach.stayhub.model.locatario;

import javax.validation.constraints.NotBlank;

public record DadosCadastroLocatario(
        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @NotBlank
        String email

) {
}
