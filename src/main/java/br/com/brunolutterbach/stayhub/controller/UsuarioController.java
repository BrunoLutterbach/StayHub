package br.com.brunolutterbach.stayhub.controller;

import br.com.brunolutterbach.stayhub.model.user.DadosAtualizacaoUsuario;
import br.com.brunolutterbach.stayhub.model.user.DadosCadastroUsuario;
import br.com.brunolutterbach.stayhub.model.user.DadosListagemUsuario;
import br.com.brunolutterbach.stayhub.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemUsuario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = service.atualizarUsuario(id, dados);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemUsuario> getUsuario(@PathVariable Long id) {
        var usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listarTodos(Pageable pageable) {
        var usuario = service.listarTodos(pageable);
        return ResponseEntity.ok(usuario);
    }


}
