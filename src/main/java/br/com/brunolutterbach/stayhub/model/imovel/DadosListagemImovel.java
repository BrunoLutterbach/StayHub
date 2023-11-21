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
                imovel.getFotos(),
                imovel.getValor());
    }
}
