package br.gov.sc.sctec.empreendedorismo.backend.api.service;

import br.gov.sc.sctec.empreendedorismo.backend.api.common.exception.NotFoundException;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToReadDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToSaveDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.model.Empreendimento;
import br.gov.sc.sctec.empreendedorismo.backend.api.model.Segmento;
import br.gov.sc.sctec.empreendedorismo.backend.api.repository.EmpreendimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmpreendimentoService {

    private final EmpreendimentoRepository empreendimentoRepository;
    private final SegmentoService segmentoService;

    public EmpreendimentoService(EmpreendimentoRepository empreendimentoRepository,
                                 SegmentoService segmentoService) {
        this.empreendimentoRepository = empreendimentoRepository;
        this.segmentoService = segmentoService;
    }

    @Transactional(readOnly = true)
    public List<EmpreendimentoToReadDto> findAll() {
        List<Empreendimento> list = empreendimentoRepository.findAll();
        log.info("---> findAll(), achou lista com {} empreendimentos.",  list.size());
        return list
                .stream()
                .map(EmpreendimentoToReadDto::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public EmpreendimentoToReadDto findOne(Long idEmpreendimento) throws NotFoundException {
        Empreendimento empreendimento = this.findById(idEmpreendimento);
        log.info("---> findOne(), achou empreendimento com ID = {}.",  idEmpreendimento);
        return EmpreendimentoToReadDto.fromEntity(empreendimento);
    }

    @Transactional()
    public void delete(Long idEmpreendimento) {
        Empreendimento empreendimento = this.findById(idEmpreendimento);
        log.info("---> delete(), encontrou e vai deletar empreendimento com ID = {}.", idEmpreendimento);
        empreendimentoRepository.delete(empreendimento);
    }

    @Transactional
    public EmpreendimentoToReadDto insert(EmpreendimentoToSaveDto dtoToSave) {
        log.info("---> insert(), recebeu empreendimento para incluir: {}.", dtoToSave);

        // Validar o Segmento informado.
        Segmento segmento = segmentoService.findById(dtoToSave.idSegmento());

        // Agora, incluir.
        Empreendimento empreendimento = new Empreendimento();

        empreendimento.setNome(dtoToSave.nome());
        empreendimento.setResponsavel(dtoToSave.responsavel());
        empreendimento.setMunicipio(dtoToSave.municipio());
        empreendimento.setSegmento(segmento);
        empreendimento.setEmail(dtoToSave.email());
        empreendimento.setAtivo(dtoToSave.ativo());
        empreendimento.setDataCriacao(LocalDateTime.now());

        empreendimento = empreendimentoRepository.save(empreendimento);

        EmpreendimentoToReadDto dtoOutput = EmpreendimentoToReadDto.fromEntity(empreendimento);
        log.info("---> insert(), incluiu empreendimento: {}.", dtoOutput);
        return dtoOutput;
    }

    @Transactional
    public EmpreendimentoToReadDto update(Long idEmpreendimento,
                                          EmpreendimentoToSaveDto dtoToSave) {
        log.info("---> update(), recebeu empreendimento para atualizar: {}.", dtoToSave);

        // Validar o id do Empreendimento informado.
        Empreendimento empreendimento = this.findById(idEmpreendimento);

        // Validar o Segmento informado.
        Segmento segmento = segmentoService.findById(dtoToSave.idSegmento());

        // Agora, atualizar.
        empreendimento.setNome(dtoToSave.nome());
        empreendimento.setResponsavel(dtoToSave.responsavel());
        empreendimento.setMunicipio(dtoToSave.municipio());
        empreendimento.setSegmento(segmento);
        empreendimento.setEmail(dtoToSave.email());
        empreendimento.setAtivo(dtoToSave.ativo());

        empreendimentoRepository.save(empreendimento);

        EmpreendimentoToReadDto dtoOutput = EmpreendimentoToReadDto.fromEntity(empreendimento);
        log.info("---> update(), atualizou empreendimento: {}.", dtoOutput);
        return dtoOutput;
    }

    @Transactional
    public EmpreendimentoToReadDto activate(Long idEmpreendimento,
                                            boolean ativar) {
        log.info("---> activate(), recebeu empreendimento para {}: ID = {}.", ativar ? "ativar" : "desativar", idEmpreendimento);

        Empreendimento empreendimento = this.findById(idEmpreendimento);
        empreendimento.setAtivo(ativar);
        empreendimentoRepository.save(empreendimento);

        EmpreendimentoToReadDto dtoOutput = EmpreendimentoToReadDto.fromEntity(empreendimento);
        log.info("---> activate(), {} empreendimento: ID = {}.", ativar ? "ativou" : "desativou", idEmpreendimento);
        return dtoOutput;
    }

    private Empreendimento findById(Long idEmpreendimento) {
        Optional<Empreendimento> dto = empreendimentoRepository.findById(idEmpreendimento);
        if (dto.isPresent()) {
            return dto.get();
        } else {
            log.error("---> findOne(), empreendimento com ID = {} não encontrado.",  idEmpreendimento);
            throw new NotFoundException(String.format("Empreendimento com ID = %d não encontrado.", idEmpreendimento));
        }
    }

}
