package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.model.locatario.DadosAtualizacaoLocatario;
import br.com.brunolutterbach.stayhub.model.locatario.DadosCadastroLocatario;
import br.com.brunolutterbach.stayhub.model.locatario.DadosListagemLocatario;
import br.com.brunolutterbach.stayhub.model.locatario.Locatario;
import br.com.brunolutterbach.stayhub.repository.LocatarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocatarioService {

    final LocatarioRepository repository;

    public DadosListagemLocatario criarUsuario(DadosCadastroLocatario dados) {
        var usuario = new Locatario(dados);
        repository.save(usuario);
        return new DadosListagemLocatario(usuario);
    }

    public DadosListagemLocatario atualizarUsuario(Long id, DadosAtualizacaoLocatario dados) {
        var usuario = repository.getReferenceById(id);
        usuario.atualizar(dados);
        repository.save(usuario);
        return new DadosListagemLocatario(usuario);
    }

    public DadosListagemLocatario buscarPorId(Long id) {
        var usuario = repository.getReferenceById(id);
        return new DadosListagemLocatario(usuario);
    }

    public Page<DadosListagemLocatario> listarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemLocatario::new);
    }

    public void removerUsuario(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new IllegalArgumentException("Usuário não encontrado");
    }
}
