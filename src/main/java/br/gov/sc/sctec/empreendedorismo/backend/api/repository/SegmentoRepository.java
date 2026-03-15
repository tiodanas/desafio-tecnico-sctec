package br.gov.sc.sctec.empreendedorismo.backend.api.repository;

import br.gov.sc.sctec.empreendedorismo.backend.api.model.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SegmentoRepository extends JpaRepository<Segmento, Long> {

    Optional<Segmento> findFirstByOrderByIdDesc();

}
