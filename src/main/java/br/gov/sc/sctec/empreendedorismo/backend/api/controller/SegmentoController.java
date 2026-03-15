package br.gov.sc.sctec.empreendedorismo.backend.api.controller;

import br.gov.sc.sctec.empreendedorismo.backend.api.dto.SegmentoToReadDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.SegmentoToSaveDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.service.SegmentoService;
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
@RequestMapping("/api/v1/segmentos")
@Tag(name = "Segmentos", description = "Operações disponíveis a serem executadas sobre o(s) segmento(s)")
public class SegmentoController {

    private final SegmentoService segmentoService;

    public SegmentoController(SegmentoService segmentoService) {
        this.segmentoService = segmentoService;
    }

    @GetMapping
    @Operation(summary = "Retorna uma lista com todos os segmentos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Lista encontrada com sucesso, pode ser vazia caso não existe nenhum segmento cadastrado.",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SegmentoToReadDto.class))) }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> findAll() {
        List<SegmentoToReadDto> list = segmentoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{idSegmento}")
    @Operation(summary = "Retorna um segmento cadastrado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Segmento encontrado com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SegmentoToReadDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Segmento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> findOne(
            @Parameter(description = "ID do segmento a ser buscado.")
            @PathVariable("idSegmento") Long idSegmento) {
        SegmentoToReadDto dto = segmentoService.findOne(idSegmento);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{idSegmento}")
    @Operation(summary = "Deleta um segmento cadastrado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Segmento deletado com sucesso.", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404",
                    description = "Segmento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> delete(
            @Parameter(description = "ID do segmento a ser deletado.")
            @PathVariable("idSegmento") Long idSegmento) {
        segmentoService.delete(idSegmento);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping
    @Operation(summary = "Insere um segmento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Segmento inserido com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SegmentoToReadDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Segmento a ser inserido foi informado com dados inválidos.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> insert(
            @Parameter(description = "Dados do segmento a ser inserido.")
            @RequestBody @Valid SegmentoToSaveDto dtoInput) {
        SegmentoToReadDto dtoOutput = segmentoService.insert(dtoInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoOutput);
    }

    @PutMapping("/{idSegmento}")
    @Operation(summary = "Atualiza um segmento.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Segmento atualizado com sucesso.",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SegmentoToReadDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Segmento a ser atualizado foi informado com dados inválidos.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    description = "Segmento não encontrado - não cadastrado.",
                    content = {@Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500",
                    description = "Erro interno na API.",
                    content = {@Content(mediaType = "application/json") }) })
    public ResponseEntity<Object> update(
            @Parameter(description = "ID do segmento a ser atualizado.")
            @PathVariable("idSegmento") Long idSegmento,
            @Parameter(description = "Dados do segmento a ser atualizado.")
            @RequestBody @Valid SegmentoToSaveDto dtoInput) {
        SegmentoToReadDto dtoOutput = segmentoService.update(idSegmento, dtoInput);
        return ResponseEntity.status(HttpStatus.OK).body(dtoOutput);
    }

}
