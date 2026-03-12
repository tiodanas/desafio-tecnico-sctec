package br.gov.sc.sctec.empreendedorismo.backend.api.dto;

import br.gov.sc.sctec.empreendedorismo.backend.api.model.Empreendimento;

import java.time.LocalDateTime;

public record EmpreendimentoToReadDto(
        Long id,
        String nome,
        String responsavel,
        String municipio,
        String tipoSegmento,
        String email,
        Boolean ativo,
        LocalDateTime dataCriacao) {

    // Metodo estatico para conversao de Entity to Dto
    public static EmpreendimentoToReadDto fromEntity(Empreendimento empreendimento) {
        return new EmpreendimentoToReadDto(
                empreendimento.getId(),
                empreendimento.getNome(),
                empreendimento.getResponsavel(),
                empreendimento.getMunicipio(),
                empreendimento.getTipoSegmento().toString(),
                empreendimento.getEmail(),
                empreendimento.getAtivo(),
                empreendimento.getDataCriacao()
        );
    }
}
