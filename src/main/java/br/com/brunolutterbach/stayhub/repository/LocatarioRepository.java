package br.com.brunolutterbach.stayhub.repository;

import br.com.brunolutterbach.stayhub.model.locatario.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
}
