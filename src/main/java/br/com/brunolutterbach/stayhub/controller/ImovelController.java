package br.com.brunolutterbach.stayhub.controller;

import br.com.brunolutterbach.stayhub.service.ImovelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/imovel")
@AllArgsConstructor
public class ImovelController {

    final ImovelService service;



}
