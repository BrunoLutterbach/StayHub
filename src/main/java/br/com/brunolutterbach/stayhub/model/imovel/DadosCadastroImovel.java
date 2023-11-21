package br.com.brunolutterbach.stayhub.model.imovel;

import java.math.BigDecimal;
import java.util.List;

public record DadosCadastroImovel(
        String nome,
        String endereco,
        String cidade,
        UnidadeFederacao uf,
        String cep,
        CategoriaImovel categoriaImovel,
        String descricao,
        List<String> fotos,
        BigDecimal valor
) {
}
