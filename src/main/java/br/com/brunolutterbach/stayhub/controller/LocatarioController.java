package br.com.brunolutterbach.stayhub.controller;

import br.com.brunolutterbach.stayhub.model.locatario.DadosAtualizacaoLocatario;
import br.com.brunolutterbach.stayhub.model.locatario.DadosCadastroLocatario;
import br.com.brunolutterbach.stayhub.model.locatario.DadosListagemLocatario;
import br.com.brunolutterbach.stayhub.service.LocatarioService;
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
public class LocatarioController {

    final LocatarioService service;

    @PostMapping()
    public ResponseEntity<DadosListagemLocatario> criarUsuario(@RequestBody @Valid DadosCadastroLocatario dados, UriComponentsBuilder uriBuilder) {
        var usuario = service.criarUsuario(dados);
        var uri = uriBuilder.path("/api/usuario/{id}").buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemLocatario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoLocatario dados) {
        var usuario = service.atualizarUsuario(id, dados);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemLocatario> getUsuario(@PathVariable Long id) {
        var usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLocatario>> listarTodos(Pageable pageable) {
        var usuario = service.listarTodos(pageable);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerUsuario(@PathVariable Long id) {
        service.removerUsuario(id);
        return ResponseEntity.noContent().build();

    }


}
