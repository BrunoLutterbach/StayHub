package br.com.brunolutterbach.stayhub.repository;

import br.com.brunolutterbach.stayhub.model.carteira.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
