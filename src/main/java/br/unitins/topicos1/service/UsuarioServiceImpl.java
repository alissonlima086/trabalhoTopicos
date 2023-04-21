package br.unitins.topicos1.service;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<UsuarioResponseDTO> getAll(){
        List<Usuario> list = usuarioRepository.listAll();
        return list.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findById(Long id){
        Usuario usuario = usuarioRepository.findById(id);
        if(usuario == null){
            throw new NotFoundException("Usuario não encontrado.");
        }
        return new UsuarioResponseDTO(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuarioDTO) throws ConstraintViolationException{
        validar(usuarioDTO);

        Usuario entity = new Usuario();

        entity.setNome(usuarioDTO.nome());
        entity.setCpf(usuarioDTO.cpf());
        entity.setEmail(usuarioDTO.email());
        entity.setSenha(usuarioDTO.senha());

        usuarioRepository.persist(entity);

        return new UsuarioResponseDTO(entity);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws ConstraintViolationException{
        validar(usuarioDTO);

        Usuario entity = usuarioRepository.findById(id);

        entity.setNome(usuarioDTO.nome());

        return new UsuarioResponseDTO(entity);
    }

    public void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException{
        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome){
        List<Usuario> list = usuarioRepository.findByNome(nome);
        return list.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count(){
        return usuarioRepository.count();
    }
    
}
