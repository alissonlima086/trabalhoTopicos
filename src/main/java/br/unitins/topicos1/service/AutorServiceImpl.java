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


import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.AutorResponseDTO;
import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.repository.AutorRepository;


@ApplicationScoped
public class AutorServiceImpl implements AutorService {

    @Inject
    AutorRepository autorRepository;

    @Inject
    Validator validator;

    @Override
    public List<AutorResponseDTO> getAll(){
        List<Autor> list = autorRepository.listAll();
        return list.stream().map(AutorResponseDTO::new).collect(Collectors.toList());
    }
    
    @Override
    public AutorResponseDTO findById(Long id){
        Autor autor = autorRepository.findById(id);
        if(autor == null){
            throw new NotFoundException("Autor não encontrado");
        }
        return new AutorResponseDTO(autor);
    }

    @Override
    @Transactional
    public AutorResponseDTO create(AutorDTO autorDTO) throws ConstraintViolationException{
        validar(autorDTO);

        Autor entity = new Autor();
        entity.setNome(autorDTO.nome());
        entity.setBio(autorDTO.bio());
        

        autorRepository.persist(entity);

        return new AutorResponseDTO(entity);
    }

    @Override
    @Transactional
    public AutorResponseDTO update(Long id, AutorDTO autorDTO) throws ConstraintViolationException{
        validar(autorDTO);

        Autor entity = autorRepository.findById(id);

        entity.setNome(autorDTO.nome());

        return new AutorResponseDTO(entity);
    }

    public void validar(AutorDTO autorDTO) throws ConstraintViolationException{
        Set<ConstraintViolation<AutorDTO>> violations = validator.validate(autorDTO);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id){
        autorRepository.deleteById(id);
    }

    @Override
    public List<AutorResponseDTO> findByNome(String nome){
        List<Autor> list = autorRepository.findByNome(nome);
        return list.stream().map(AutorResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count(){
        return autorRepository.count();
    }

}

 