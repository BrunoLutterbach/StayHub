package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.model.imovel.DadosCadastroImovel;
import br.com.brunolutterbach.stayhub.model.imovel.DadosListagemImovel;
import br.com.brunolutterbach.stayhub.model.imovel.Imovel;
import br.com.brunolutterbach.stayhub.repository.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImovelService {

    final ImovelRepository repository;

    public DadosListagemImovel cadastrarImovel(DadosCadastroImovel dados) {
        var imovel = new Imovel(dados);
        repository.save(imovel);
        return new DadosListagemImovel(imovel);

    }
}
