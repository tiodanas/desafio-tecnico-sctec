package br.gov.sc.sctec.empreendedorismo.backend.api.service;

import br.gov.sc.sctec.empreendedorismo.backend.api.common.exception.NotFoundException;
import br.gov.sc.sctec.empreendedorismo.backend.api.common.exception.NotImplementedException;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToReadDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.dto.EmpreendimentoToUpdateDto;
import br.gov.sc.sctec.empreendedorismo.backend.api.model.Empreendimento;
import br.gov.sc.sctec.empreendedorismo.backend.api.repository.EmpreendimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        log.debug("---> findAll(), achou lista com {} Empreendimentos.",  list.size());
        return list
                .stream()
                .map(EmpreendimentoToReadDto::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public EmpreendimentoToReadDto findOne(Long idEmpreendimento) throws NotFoundException {
        Empreendimento empreendimento = this.findById(idEmpreendimento);
        log.debug("---> findOne(), achou Empreendimento com ID = {}.",  idEmpreendimento);
        return EmpreendimentoToReadDto.fromEntity(empreendimento);
    }

    @Transactional()
    public void delete(Long idEmpreendimento) {
        Empreendimento empreendimento = this.findById(idEmpreendimento);
        log.info("---> delete(), encontrou e vai deletar Empreendimento com ID = {}.", idEmpreendimento);
        empreendimentoRepository.delete(empreendimento);
    }

    public void save() {
        throw new NotImplementedException();
    }

    public EmpreendimentoToReadDto update(Long idEmpreendimento,
                       EmpreendimentoToUpdateDto dto) {
        Empreendimento empreendimento = this.findById(idEmpreendimento);

        empreendimento.setNome(dto.nome());
        empreendimento.setResponsavel(dto.responsavel());
        empreendimento.setMunicipio(dto.municipio());
        empreendimento.setTipoSegmento(dto.tipoSegmento());
        empreendimento.setEmail(dto.email());
        empreendimento.setAtivo(dto.ativo());

        empreendimentoRepository.save(empreendimento);

        return EmpreendimentoToReadDto.fromEntity(empreendimento);
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
