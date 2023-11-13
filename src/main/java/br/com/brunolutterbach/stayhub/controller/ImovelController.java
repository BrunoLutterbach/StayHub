package br.com.brunolutterbach.stayhub.controller;

import br.com.brunolutterbach.stayhub.model.imovel.DadosCadastroImovel;
import br.com.brunolutterbach.stayhub.model.imovel.DadosListagemImovel;
import br.com.brunolutterbach.stayhub.service.ImovelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

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



}
