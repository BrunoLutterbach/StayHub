package br.com.brunolutterbach.stayhub.repository;

import br.com.brunolutterbach.stayhub.model.carteira.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
