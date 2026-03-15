package br.gov.sc.sctec.empreendedorismo.backend.api.service;

import br.gov.sc.sctec.empreendedorismo.backend.api.common.exception.NotFoundException;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.SegmentoToReadDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.SegmentoToSaveDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.model.Segmento;
import br.gov.sc.sctec.empreendedorismo.backend.api.repository.SegmentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SegmentoService {

    private final SegmentoRepository segmentoRepository;

    public SegmentoService(SegmentoRepository segmentoRepository) {
        this.segmentoRepository = segmentoRepository;
    }

    @Transactional(readOnly = true)
    public List<SegmentoToReadDto> findAll() {
        List<Segmento> list = segmentoRepository.findAll();
        log.info("---> findAll(), achou lista com {} segmentos.",  list.size());
        return list
                .stream()
                .map(SegmentoToReadDto::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public SegmentoToReadDto findOne(Long idSegmento) throws NotFoundException {
        Segmento segmento = this.findById(idSegmento);
        log.info("---> findOne(), achou segmento com ID = {}.",  idSegmento);
        return SegmentoToReadDto.fromEntity(segmento);
    }

    @Transactional()
    public void delete(Long idSegmento) {
        Segmento segmento = this.findById(idSegmento);
        log.info("---> delete(), encontrou e vai deletar segmento com ID = {}.", idSegmento);
        segmentoRepository.delete(segmento);
    }

    @Transactional
    public SegmentoToReadDto insert(SegmentoToSaveDto dtoToSave) {
        log.info("---> insert(), recebeu segmento para incluir: {}.", dtoToSave);

        Segmento segmento = new Segmento();

        Long nextId = this.findNextId();
        log.info("---> insert(), novo ID: {}.", nextId);

        segmento.setId(nextId);
        segmento.setNome(dtoToSave.nome());
        segmento.setDataCriacao(LocalDateTime.now());

        segmento = segmentoRepository.save(segmento);

        SegmentoToReadDto dtoOutput = SegmentoToReadDto.fromEntity(segmento);
        log.info("---> insert(), incluiu segmento: {}.", dtoOutput);
        return dtoOutput;
    }

    @Transactional
    public SegmentoToReadDto update(Long idSegmento,
                                    SegmentoToSaveDto dtoInput) {
        log.info("---> update(), recebeu segmento para atualizar: {}.", dtoInput);

        Segmento segmento = this.findById(idSegmento);

        segmento.setNome(dtoInput.nome());

        segmentoRepository.save(segmento);

        SegmentoToReadDto dtoOutput = SegmentoToReadDto.fromEntity(segmento);
        log.info("---> update(), atualizou segmento: {}.", dtoOutput);
        return dtoOutput;
    }

    public Segmento findById(Long idEmpreendimento) {
        Optional<Segmento> dto = segmentoRepository.findById(idEmpreendimento);
        if (dto.isPresent()) {
            return dto.get();
        } else {
            log.error("---> findOne(), segmento com ID = {} não encontrado.",  idEmpreendimento);
            throw new NotFoundException(String.format("Segmento com ID = %d não encontrado.", idEmpreendimento));
        }
    }

    private Long findNextId() {
        Optional<Segmento> segmentoOptional = segmentoRepository.findFirstByOrderByIdDesc();
        return segmentoOptional.map(segmento -> segmento.getId() + 1).orElse(1L);
    }

}
