package br.unitins.topicos1.service;

import java.util.List;
import java.util.set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.topicos1.dto.MunicipioResponseDTO;
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
    public List<QuadrinhoResponseDTO> getAll(){
        List<Quadrinho> list = quadrinhoRepository.listAll();
        return list.stream().map(QuadrinhoResponseDTO: new).collect(Collectors.toList());
    }

    @Override
    public QuadrinhoResponseDTO findById(Long id){
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        if(quadrinho == null){
            throw new NotFoundException("Quadrinho não encontrado. ");
        }
        return new QuadrinhoResponseDTO(quadrinho);
    }

    @Override
    @Transactional
    public QuadrinhoResponseDTO create(QuadrinhoDTO quadrinhoDTO) throws ConstraintViolationException{
        validar(quadrinhoDTO);

        Quadrinho entity = new Quadrinho(null, null, null, null, null, null, null, null, null, null, null);
        entity.setNome(quadrinhoDTO.getNome());
    }
    
}
