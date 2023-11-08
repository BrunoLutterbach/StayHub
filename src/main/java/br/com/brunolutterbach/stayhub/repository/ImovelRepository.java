package br.com.brunolutterbach.stayhub.repository;

import br.com.brunolutterbach.stayhub.model.imovel.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
