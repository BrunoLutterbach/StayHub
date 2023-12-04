package br.com.brunolutterbach.stayhub.repository;

import br.com.brunolutterbach.stayhub.inquilino.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
}
