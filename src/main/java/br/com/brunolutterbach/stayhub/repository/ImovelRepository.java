package br.com.brunolutterbach.stayhub.repository;

import br.com.brunolutterbach.stayhub.model.imovel.DadosListagemImovel;
import br.com.brunolutterbach.stayhub.model.imovel.Imovel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    Optional<DadosListagemImovel> findByUf(Pageable pageable, String uf);
}
