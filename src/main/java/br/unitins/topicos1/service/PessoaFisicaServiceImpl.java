package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

import br.unitins.topicos1.dto.PessoaFisicaDTO;
import br.unitins.topicos1.dto.PessoaFisicaResponseDTO;
import br.unitins.topicos1.model.PessoaFisica;
import br.unitins.topicos1.repository.PessoaFisicaRepository;

@ApplicationScoped
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Inject
    PessoaFisicaRepository PessoaFisicaRepository;

    @Inject
    Validator validator;

    @Override
    public List<PessoaFisicaResponseDTO> getAll() {
        List<PessoaFisica> list = PessoaFisicaRepository.listAll();
        return list.stream().map(PessoaFisicaResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public PessoaFisicaResponseDTO findById(Long id) {
        PessoaFisica PessoaFisica = PessoaFisicaRepository.findById(id);
        if (PessoaFisica == null)
            throw new NotFoundException("PessoaFisica não encontrado.");
        return new PessoaFisicaResponseDTO(PessoaFisica);
    }

    @Override
    @Transactional
    public PessoaFisicaResponseDTO create(PessoaFisicaDTO PessoaFisicaDTO) throws ConstraintViolationException {
        validar(PessoaFisicaDTO);

        PessoaFisica entity = new PessoaFisica();
        entity.setEmail(PessoaFisicaDTO.email());
        entity.setCpf(PessoaFisicaDTO.cpf());

        PessoaFisicaRepository.persist(entity);

        return new PessoaFisicaResponseDTO(entity);
    }

    public PessoaFisica createPessoaFisica(PessoaFisicaDTO PessoaFisicaDTO) throws ConstraintViolationException {
        validar(PessoaFisicaDTO);

        PessoaFisica entity = new PessoaFisica();
        entity.setEmail(PessoaFisicaDTO.email());
        entity.setCpf(PessoaFisicaDTO.cpf());

        PessoaFisicaRepository.persist(entity);

        return entity;
    }

    @Override
    @Transactional
    public PessoaFisicaResponseDTO update(Long id, PessoaFisicaDTO PessoaFisicaDTO)
            throws ConstraintViolationException {
        validar(PessoaFisicaDTO);

        PessoaFisica entity = PessoaFisicaRepository.findById(id);

        entity.setNome(PessoaFisicaDTO.nome());
        entity.setEmail(PessoaFisicaDTO.email());
        entity.setCpf(PessoaFisicaDTO.cpf());

        return new PessoaFisicaResponseDTO(entity);
    }

    private void validar(PessoaFisicaDTO PessoaFisicaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PessoaFisicaDTO>> violations = validator.validate(PessoaFisicaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        PessoaFisicaRepository.deleteById(id);
    }

    @Override
    public List<PessoaFisicaResponseDTO> findByNome(String email) {
        List<PessoaFisica> list = PessoaFisicaRepository.findByNome(email);
        return list.stream().map(PessoaFisicaResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return PessoaFisicaRepository.count();
    }

}
