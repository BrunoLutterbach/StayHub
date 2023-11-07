package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.model.user.DadosCadastroUsuario;
import br.com.brunolutterbach.stayhub.model.user.DadosListagemUsuario;
import br.com.brunolutterbach.stayhub.model.user.Usuario;
import br.com.brunolutterbach.stayhub.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
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
}
