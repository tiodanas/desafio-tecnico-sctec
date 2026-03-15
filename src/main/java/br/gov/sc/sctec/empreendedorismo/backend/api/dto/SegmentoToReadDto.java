package br.gov.sc.sctec.empreendedorismo.backend.api.dto;

import br.gov.sc.sctec.empreendedorismo.backend.api.model.Segmento;

import java.time.LocalDateTime;

public record SegmentoToReadDto(
        Long id,
        String nome,
        LocalDateTime dataCriacao) {

    // Metodo estatico para conversao de Entity to Dto
    public static SegmentoToReadDto fromEntity(Segmento segmento) {
        return new SegmentoToReadDto(
                segmento.getId(),
                segmento.getNome(),
                segmento.getDataCriacao()
        );
    }
}
