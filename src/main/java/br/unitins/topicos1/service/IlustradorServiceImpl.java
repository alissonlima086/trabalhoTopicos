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

import br.unitins.topicos1.dto.IlustradorDTO;
import br.unitins.topicos1.dto.IlustradorResponseDTO;
import br.unitins.topicos1.model.Ilustrador;
import br.unitins.topicos1.repository.IlustradorRepository;


@ApplicationScoped
public class IlustradorServiceImpl implements IlustradorService{

    @Inject
    IlustradorRepository ilustradorRepository;

    @Inject
    Validator validator;

    @Override
    public List<IlustradorResponseDTO> getAll(){
        List<Ilustrador> list = ilustradorRepository.listAll();
        return list.stream().map(IlustradorResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public IlustradorResponseDTO findById(Long id){
        Ilustrador ilustrador = ilustradorRepository.findById(id);
        if(ilustrador == null){
            throw new NotFoundException("Ilustrador não encontrado");
        }

        return new IlustradorResponseDTO(ilustrador);
    }

    @Override
    @Transactional
    public IlustradorResponseDTO create(IlustradorDTO ilustradorDTO) throws ConstraintViolationException{
        validar(ilustradorDTO);

        Ilustrador entity = new Ilustrador();
        entity.setNome(ilustradorDTO.nome());
        entity.setBio(ilustradorDTO.bio());

        ilustradorRepository.persist(entity);

        return new IlustradorResponseDTO(entity);
    }

    @Override
    @Transactional
    public IlustradorResponseDTO update(Long id, IlustradorDTO ilustradorDTO) throws ConstraintViolationException{
        validar(ilustradorDTO);

        Ilustrador entity = ilustradorRepository.findById(id);

        entity.setNome(ilustradorDTO.nome());

        return new IlustradorResponseDTO(entity);
    }

    public void validar(IlustradorDTO ilustradorDTO) throws ConstraintViolationException{
        Set<ConstraintViolation<IlustradorDTO>> violations = validator.validate(ilustradorDTO);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id){
        ilustradorRepository.deleteById(id);
    }
    
    @Override
    public List<IlustradorResponseDTO> findByNome(String nome){
        List<Ilustrador> list = ilustradorRepository.findByNome(nome);
        return list.stream().map(IlustradorResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count(){
        return ilustradorRepository.count();
    }
}
