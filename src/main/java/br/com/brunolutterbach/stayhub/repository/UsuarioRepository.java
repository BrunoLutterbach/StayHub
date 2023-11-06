package br.com.brunolutterbach.stayhub.repository;

import br.com.brunolutterbach.stayhub.model.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
