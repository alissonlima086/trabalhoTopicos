package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.topicos1.dto.QuadrinhoDTO;
import br.unitins.topicos1.dto.QuadrinhoResponseDTO;
import br.unitins.topicos1.model.Quadrinho;
import br.unitins.topicos1.repository.QuadrinhoRepository;

@ApplicationScoped
public class QuadrinhoServiceImpl implements QuadrinhoService {


    @Inject
    QuadrinhoRepository quadrinhoRepository;

    @Inject
    Validator validator;

    @Override
    public List<QuadrinhoResponseDTO> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public QuadrinhoResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public QuadrinhoResponseDTO create(QuadrinhoDTO quadrinhoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public QuadrinhoResponseDTO update(Long id, QuadrinhoDTO quadrinhoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<QuadrinhoResponseDTO> findByNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNome'");
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

   
    
}
