package br.com.brunolutterbach.stayhub.model.user;

public record DadosCadastroUsuario(
        String nome,
        String senha,
        String email,
        TipoUsuario tipoUsuario

) {
}
