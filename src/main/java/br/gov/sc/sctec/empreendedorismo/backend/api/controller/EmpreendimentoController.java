package br.gov.sc.sctec.empreendedorismo.backend.api.controller;

import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToReadDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToSaveDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.service.EmpreendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empreendimentos")
@Tag(name = "Empreendimentos", description = "Operações disponíveis a sereme executadas sobre o(s) empreendimento(s)")
public class EmpreendimentoController {

    private final EmpreendimentoService empreendimentoService;

    public EmpreendimentoController(EmpreendimentoService empreendimentoService) {
        this.empreendimentoService = empreendimentoService;
    }

    @GetMapping
    @Operation(summary = "Retorna uma lista com todos os empreendimentos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Lista encontrada com sucesso, pode ser vazia caso não existe nenhum empreendimento cadastrado.",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmpreendimentoToReadDto.class))) }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> findAll() {
        List<EmpreendimentoToReadDto> list = empreendimentoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{idEmpreendimento}")
    @Operation(summary = "Retorna um empreendimento cadastrado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Empreendimento encontrado com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EmpreendimentoToReadDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Empreendimento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> findOne(
            @Parameter(description = "ID do empreendimento a ser buscado.")
            @PathVariable("idEmpreendimento") Long idEmpreendimento) {
        EmpreendimentoToReadDto dto = empreendimentoService.findOne(idEmpreendimento);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{idEmpreendimento}")
    @Operation(summary = "Deleta um empreendimento cadastrado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Empreendimento deletado com sucesso.", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404",
                    description = "Empreendimento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> delete(
            @Parameter(description = "ID do empreendimento a ser deletado.")
            @PathVariable("idEmpreendimento") Long idEmpreendimento) {
        empreendimentoService.delete(idEmpreendimento);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping
    @Operation(summary = "Insere um empreendimento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Empreendimento inserido com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EmpreendimentoToReadDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Empreendimento a ser inserido foi informado com dados inválidos.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> insert(
            @Parameter(description = "Dados do empreendimento a ser inserido.")
            @RequestBody @Valid EmpreendimentoToSaveDto dtoInput) {
        EmpreendimentoToReadDto dtoOutput = empreendimentoService.insert(dtoInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoOutput);
    }

    @PutMapping("/{idEmpreendimento}")
    @Operation(summary = "Atualiza um empreendimento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Empreendimento atualizado com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EmpreendimentoToReadDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Empreendimento a ser atualizado foi informado com dados inválidos.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    description = "Empreendimento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> update(
            @Parameter(description = "ID do empreendimento a ser atualizado.")
            @PathVariable("idEmpreendimento") Long idEmpreendimento,
            @Parameter(description = "Dados do empreendimento a ser atualizado.")
            @RequestBody @Valid EmpreendimentoToSaveDto dtoInput) {
        EmpreendimentoToReadDto dtoOutput = empreendimentoService.update(idEmpreendimento, dtoInput);
        return ResponseEntity.status(HttpStatus.OK).body(dtoOutput);
    }

    @PatchMapping("/{idEmpreendimento}/ativar")
    @Operation(summary = "Ativa um empreendimento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Empreendimento ativado com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EmpreendimentoToReadDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Empreendimento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> activate(
            @Parameter(description = "ID do empreendimento a ser ativado.")
            @PathVariable("idEmpreendimento") Long idEmpreendimento) {
        EmpreendimentoToReadDto dtoOutput = empreendimentoService.activate(idEmpreendimento, true);
        return ResponseEntity.status(HttpStatus.OK).body(dtoOutput);
    }

    @PatchMapping("/{idEmpreendimento}/desativar")
    @Operation(summary = "Inativa um empreendimento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Empreendimento inativado com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EmpreendimentoToReadDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Empreendimento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> inactivate(
            @Parameter(description = "ID do empreendimento a ser desativado.")
            @PathVariable("idEmpreendimento") Long idEmpreendimento) {
        EmpreendimentoToReadDto dtoOutput = empreendimentoService.activate(idEmpreendimento, false);
        return ResponseEntity.status(HttpStatus.OK).body(dtoOutput);
    }

}
