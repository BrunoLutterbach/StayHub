package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.model.imovel.DadosAtualizacaoImovel;
import br.com.brunolutterbach.stayhub.model.imovel.DadosCadastroImovel;
import br.com.brunolutterbach.stayhub.model.imovel.DadosListagemImovel;
import br.com.brunolutterbach.stayhub.model.imovel.Imovel;
import br.com.brunolutterbach.stayhub.repository.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ImovelService {

    final ImovelRepository repository;

    public DadosListagemImovel cadastrarImovel(DadosCadastroImovel dados) {
        var imovel = new Imovel(dados);
        repository.save(imovel);
        return new DadosListagemImovel(imovel);

    }

    public DadosListagemImovel buscarPorId(Long id) {
        var imovel = repository.getReferenceById(id);
        return new DadosListagemImovel(imovel);
    }

    public Page<DadosListagemImovel> listarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemImovel::new);
    }

    public DadosListagemImovel ativarImovel(Long id) {
        var imovel = repository.getReferenceById(id);
        imovel.setAtivo(true);
        repository.save(imovel);
        return new DadosListagemImovel(imovel);
    }

    public DadosListagemImovel atualizarImovel(Long id, DadosAtualizacaoImovel dados) {
        var imovel = repository.getReferenceById(id);
        imovel.atualizar(dados);
        repository.save(imovel);
        return new DadosListagemImovel(imovel);
    }

    public Optional<DadosListagemImovel> buscarImovelPorUF(Pageable pageable, String uf) {
        return repository.findByUf(pageable, uf).map(DadosListagemImovel::new);
    }
}
