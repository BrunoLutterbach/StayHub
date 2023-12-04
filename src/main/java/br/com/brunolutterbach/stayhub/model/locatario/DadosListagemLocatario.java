package br.com.brunolutterbach.stayhub.model.locatario;

public record DadosListagemLocatario(
        Long id,
        String nome,
        String email
) {
    public DadosListagemLocatario(Locatario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
