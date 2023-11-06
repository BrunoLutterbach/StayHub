package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.repository.CarteiraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarteiraService {

    final CarteiraRepository repository;

}
