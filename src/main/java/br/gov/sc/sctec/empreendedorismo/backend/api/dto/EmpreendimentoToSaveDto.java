package br.gov.sc.sctec.empreendedorismo.backend.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EmpreendimentoToSaveDto(

        @NotBlank(message = "O nome não pode ser vazio.")
        @Size(min = 3, max = 200, message = "O nome deve conter entre 3 e 200 caracteres.")
        String nome,

        @NotBlank(message = "O responsável não pode ser vazio.")
        @Size(min = 3, max = 200, message = "O responsável deve conter entre 3 e 200 caracteres.")
        String responsavel,

        @NotBlank(message = "O município não pode ser vazio.")
        @Size(min = 3, max = 150, message = "O município deve conter entre 3 e 150 caracteres.")
        String municipio,

        @NotNull(message = "O segmento não pode ser nulo.")
        Long idSegmento,

        @NotBlank(message = "O e-mail não pode ser vazio.")
        @Email(message = "O e-mail deve ser válido.")
        String email,

        @NotNull(message = "Ativo não pode ser nulo.")
        Boolean ativo
) {
}
