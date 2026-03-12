package br.gov.sc.sctec.empreendedorismo.backend.api.repository;

import br.gov.sc.sctec.empreendedorismo.backend.api.model.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {
}
