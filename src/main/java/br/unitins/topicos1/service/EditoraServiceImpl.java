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
import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.dto.EditoraResponseDTO;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.model.Editora;

@ApplicationScoped
public class EditoraServiceImpl implements EditoraService {

  
    @Inject
    EditoraRepository editoraRepository;

    @Inject
    Validator validator;

    @Override
    public List<EditoraResponseDTO> getAll() {
        List<Editora> list = editoraRepository.listAll();
        return list.stream().map(EditoraResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public EditoraResponseDTO findById(Long id) {
        Editora editora = editoraRepository.findById(id);
        if(editora == null){
            throw new NotFoundException("Editora não encontrad1");
        }
        return new EditoraResponseDTO(editora);
    }

    @Override
    @Transactional
    public EditoraResponseDTO create(EditoraDTO editoraDTO) throws ConstraintViolationException{
        validar(editoraDTO);

        Editora entity = new Editora();

        entity.setNome(editoraDTO.nome());

        editoraRepository.persist(entity);

        return new EditoraResponseDTO(entity);
    }

    @Override
    @Transactional
    public EditoraResponseDTO update(Long id, EditoraDTO editoraDTO) throws ConstraintViolationException{
        validar(editoraDTO);
        
        Editora entity = editoraRepository.findById(id);

        entity.setNome(editoraDTO.nome());
        
        return new EditoraResponseDTO(entity);
    }

    public void validar(EditoraDTO editoraDTO) throws ConstraintViolationException{
        Set<ConstraintViolation<EditoraDTO>> violations = validator.validate(editoraDTO);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id){
        editoraRepository.deleteById(id);
    }

    @Override
    public List<EditoraResponseDTO> findByNome(String nome) {
        List<Editora> list = editoraRepository.findByNome(nome);
        return list.stream().map(EditoraResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return editoraRepository.count();
    }
}