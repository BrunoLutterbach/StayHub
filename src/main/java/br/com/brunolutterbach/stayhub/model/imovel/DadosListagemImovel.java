package br.com.brunolutterbach.stayhub.model.imovel;

import java.math.BigDecimal;
import java.util.List;

public record DadosListagemImovel(
        Long id,
        String nome,
        String endereco,
        String cidade,
        UnidadeFederacao uf,
        String cep,
        CategoriaImovel categoria,
        String descricao,
        boolean ativo,
        List<String> fotos,
        BigDecimal valor

) {
    public DadosListagemImovel(Imovel imovel) {
        this(imovel.getId(),
                imovel.getNome(),
                imovel.getEndereco(),
                imovel.getCidade(),
                imovel.getUf(),
                imovel.getCep(),
                imovel.getCategoria(),
                imovel.getDescricao(),
                imovel.isAtivo(),
                imovel.getFotos(),
                imovel.getValor());
    }

    public DadosListagemImovel(DadosListagemImovel dadosListagemImovel) {
        this(dadosListagemImovel.id(),
                dadosListagemImovel.nome(),
                dadosListagemImovel.endereco(),
                dadosListagemImovel.cidade(),
                dadosListagemImovel.uf(),
                dadosListagemImovel.cep(),
                dadosListagemImovel.categoria(),
                dadosListagemImovel.descricao(),
                dadosListagemImovel.ativo(),
                dadosListagemImovel.fotos(),
                dadosListagemImovel.valor());
    }
}
