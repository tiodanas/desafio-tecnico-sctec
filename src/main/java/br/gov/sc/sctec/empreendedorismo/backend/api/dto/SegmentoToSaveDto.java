package br.gov.sc.sctec.empreendedorismo.backend.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SegmentoToSaveDto(

        @NotBlank(message = "O nome não pode ser vazio.")
        @Size(min = 3, max = 200, message = "O nome deve conter entre 3 e 200 caracteres.")
        String nome

) {
}
