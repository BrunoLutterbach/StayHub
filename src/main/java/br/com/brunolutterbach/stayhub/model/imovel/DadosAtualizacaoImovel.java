package br.com.brunolutterbach.stayhub.model.imovel;

public record DadosAtualizacaoImovel(
        String nome,
        String endereco,
        String cidade,
        UnidadeFederacao uf,
        String cep,
        CategoriaImovel categoria,
        String descricao
) {
}
