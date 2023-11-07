package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.model.user.DadosAtualizacaoUsuario;
import br.com.brunolutterbach.stayhub.model.user.DadosCadastroUsuario;
import br.com.brunolutterbach.stayhub.model.user.DadosListagemUsuario;
import br.com.brunolutterbach.stayhub.model.user.Usuario;
import br.com.brunolutterbach.stayhub.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    final UsuarioRepository repository;

    public DadosListagemUsuario criarUsuario(DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        repository.save(usuario);
        return new DadosListagemUsuario(usuario);
    }

    public DadosListagemUsuario atualizarUsuario(Long id, DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(id);
        usuario.atualizar(dados);
        repository.save(usuario);
        return new DadosListagemUsuario(usuario);
    }

    public DadosListagemUsuario buscarPorId(Long id) {
        var usuario = repository.getReferenceById(id);
        return new DadosListagemUsuario(usuario);
    }

    public Page<DadosListagemUsuario> listarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemUsuario::new);
    }

    public void removerUsuario(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new IllegalArgumentException("Usuário não encontrado");
    }
}
