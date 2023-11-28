package br.com.brunolutterbach.stayhub.controller;

import br.com.brunolutterbach.stayhub.model.imovel.DadosAtualizacaoImovel;
import br.com.brunolutterbach.stayhub.model.imovel.DadosCadastroImovel;
import br.com.brunolutterbach.stayhub.model.imovel.DadosListagemImovel;
import br.com.brunolutterbach.stayhub.service.ImovelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/imovel")
@AllArgsConstructor
public class ImovelController {

    final ImovelService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<DadosListagemImovel> cadastrarImovel(@RequestBody @Valid DadosCadastroImovel dados, UriComponentsBuilder uriBuilder) {
        var imovel = service.cadastrarImovel(dados);
        var uri = uriBuilder.path("/api/imovel/{id}").buildAndExpand(imovel.id()).toUri();
        return ResponseEntity.created(uri).body(imovel);
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<DadosListagemImovel> atualizarImovel(@PathVariable Long id, @RequestBody DadosAtualizacaoImovel dados) {
        var imovel = service.atualizarImovel(id, dados);
        return ResponseEntity.ok(imovel);
    }

    @PatchMapping("/ativar/{id}")
    public ResponseEntity<DadosListagemImovel> ativarImovel(@PathVariable Long id) {
        var imovel = service.ativarImovel(id);
        return ResponseEntity.ok(imovel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemImovel> buscarPorId(@PathVariable Long id) {
        var imovel = service.buscarPorId(id);
        return ResponseEntity.ok(imovel);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemImovel>> listarTodos(Pageable pageable) {
        var imoveis = service.listarTodos(pageable);
        return ResponseEntity.ok(imoveis);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Optional<DadosListagemImovel>> buscarImovelPorUF(Pageable pageable, @RequestParam String uf) {
        var imoveis = service.buscarImovelPorUF(pageable, uf);
        return ResponseEntity.ok(imoveis);
    }



}
