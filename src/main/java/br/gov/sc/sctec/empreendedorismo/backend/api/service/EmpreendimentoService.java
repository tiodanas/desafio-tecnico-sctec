package br.gov.sc.sctec.empreendedorismo.backend.api.service;

import br.gov.sc.sctec.empreendedorismo.backend.api.common.exception.NotFoundException;
import br.gov.sc.sctec.empreendedorismo.backend.api.common.exception.NotImplementedException;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToReadDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToSaveDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.model.Empreendimento;
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

    public EmpreendimentoService(EmpreendimentoRepository empreendimentoRepository) {
        this.empreendimentoRepository = empreendimentoRepository;
    }

    @Transactional(readOnly = true)
    public List<EmpreendimentoToReadDto> findAll() {
        List<Empreendimento> list = empreendimentoRepository.findAll();
        log.info("---> findAll(), achou lista com {} Empreendimentos.",  list.size());
        return list
                .stream()
                .map(EmpreendimentoToReadDto::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public EmpreendimentoToReadDto findOne(Long idEmpreendimento) throws NotFoundException {
        Empreendimento empreendimento = this.findById(idEmpreendimento);
        log.info("---> findOne(), achou Empreendimento com ID = {}.",  idEmpreendimento);
        return EmpreendimentoToReadDto.fromEntity(empreendimento);
    }

    @Transactional()
    public void delete(Long idEmpreendimento) {
        Empreendimento empreendimento = this.findById(idEmpreendimento);
        log.info("---> delete(), encontrou e vai deletar Empreendimento com ID = {}.", idEmpreendimento);
        empreendimentoRepository.delete(empreendimento);
    }

    @Transactional
    public EmpreendimentoToReadDto insert(EmpreendimentoToSaveDto dtoToSave) {
        log.info("---> insert(), recebeu emrpeendimento para incluir: {}.", dtoToSave);

        Empreendimento empreendimento = new Empreendimento();

        empreendimento.setNome(dtoToSave.nome());
        empreendimento.setResponsavel(dtoToSave.responsavel());
        empreendimento.setMunicipio(dtoToSave.municipio());
        empreendimento.setTipoSegmento(dtoToSave.tipoSegmento());
        empreendimento.setEmail(dtoToSave.email());
        empreendimento.setAtivo(dtoToSave.ativo());
        empreendimento.setDataCriacao(LocalDateTime.now());

        empreendimento = empreendimentoRepository.save(empreendimento);

        EmpreendimentoToReadDto dtoOutput = EmpreendimentoToReadDto.fromEntity(empreendimento);
        log.info("---> insert(), incluiu emrpeendimento: {}.", dtoOutput);
        return dtoOutput;
    }

    @Transactional
    public EmpreendimentoToReadDto update(Long idEmpreendimento,
                                          EmpreendimentoToSaveDto dtoInput) {
        log.info("---> update(), recebeu emrpeendimento para atualizar: {}.", dtoInput);

        Empreendimento empreendimento = this.findById(idEmpreendimento);

        empreendimento.setNome(dtoInput.nome());
        empreendimento.setResponsavel(dtoInput.responsavel());
        empreendimento.setMunicipio(dtoInput.municipio());
        empreendimento.setTipoSegmento(dtoInput.tipoSegmento());
        empreendimento.setEmail(dtoInput.email());
        empreendimento.setAtivo(dtoInput.ativo());

        empreendimentoRepository.save(empreendimento);

        EmpreendimentoToReadDto dtoOutput = EmpreendimentoToReadDto.fromEntity(empreendimento);
        log.info("---> update(), atualizou emrpeendimento: {}.", dtoOutput);
        return dtoOutput;
    }

    @Transactional
    public EmpreendimentoToReadDto activate(Long idEmpreendimento) {
        throw new NotImplementedException();
    }

    @Transactional
    public EmpreendimentoToReadDto deactivate(Long idEmpreendimento) {
        throw new NotImplementedException();
    }

    private Empreendimento findById(Long idEmpreendimento) {
        Optional<Empreendimento> dto = empreendimentoRepository.findById(idEmpreendimento);
        if (dto.isPresent()) {
            return dto.get();
        } else {
            log.error("---> findOne(), Empreendimento com ID = {} não encontrado.",  idEmpreendimento);
            throw new NotFoundException(String.format("Empreendimento com ID = %d não encontrado.", idEmpreendimento));
        }
    }

}
