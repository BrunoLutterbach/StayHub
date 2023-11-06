package br.com.brunolutterbach.stayhub.service;

import br.com.brunolutterbach.stayhub.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    final UsuarioRepository repository;

}
