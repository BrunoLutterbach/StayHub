package br.com.brunolutterbach.stayhub.controller;

import br.com.brunolutterbach.stayhub.model.user.DadosCadastroUsuario;
import br.com.brunolutterbach.stayhub.model.user.DadosListagemUsuario;
import br.com.brunolutterbach.stayhub.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioController {

    final UsuarioService service;

    @PostMapping()
    public ResponseEntity<DadosListagemUsuario> criarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var usuario = service.criarUsuario(dados);
        var uri = uriBuilder.path("/api/usuario/{id}").buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }


}
