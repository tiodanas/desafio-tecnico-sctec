package br.gov.sc.sctec.empreendedorismo.backend.api.controller;

import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToReadDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.service.EmpreendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empreendimentos")
public class EmpreendimentoController {

    private final EmpreendimentoService empreendimentoService;

    public EmpreendimentoController(EmpreendimentoService empreendimentoService) {
        this.empreendimentoService = empreendimentoService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<EmpreendimentoToReadDto> list = empreendimentoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{idEmpreendimento}")
    public ResponseEntity<Object> findOne(@PathVariable("idEmpreendimento") Long idEmpreendimento) {
        EmpreendimentoToReadDto dto = empreendimentoService.findOne(idEmpreendimento);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{idEmpreendimento}")
    public ResponseEntity<Object> delete(@PathVariable("idEmpreendimento") Long idEmpreendimento) {
        empreendimentoService.delete(idEmpreendimento);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping
    public ResponseEntity<Object> save() {
        empreendimentoService.save();
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{idEmpreendimento}")
    public ResponseEntity<Object> update(@PathVariable("idEmpreendimento") Long idEmpreendimento) {
        empreendimentoService.update(idEmpreendimento);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
