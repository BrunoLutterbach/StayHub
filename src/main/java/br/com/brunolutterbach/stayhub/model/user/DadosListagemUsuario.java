package br.com.brunolutterbach.stayhub.model.user;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        TipoUsuario tipoUsuario
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipoUsuario());
    }
}
