package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.repository.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImovelService {

    final ImovelRepository repository;

}
