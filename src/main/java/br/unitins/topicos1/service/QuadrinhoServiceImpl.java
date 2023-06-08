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

import br.unitins.topicos1.dto.QuadrinhoDTO;
import br.unitins.topicos1.dto.QuadrinhoResponseDTO;
import br.unitins.topicos1.model.Quadrinho;
import br.unitins.topicos1.repository.QuadrinhoRepository;
import br.unitins.topicos1.repository.AutorRepository;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.model.Editora;
import br.unitins.topicos1.model.Encadernacao;

@ApplicationScoped
public class QuadrinhoServiceImpl implements QuadrinhoService {

  
    @Inject
    QuadrinhoRepository quadrinhoRepository;

    @Inject
    AutorRepository autorRepository;

    @Inject
    Validator validator;

    @Inject
    EditoraRepository editoraRepository;

    @Override
    public List<QuadrinhoResponseDTO> getAll() {
        List<Quadrinho> list = quadrinhoRepository.listAll();
        return list.stream().map(QuadrinhoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public QuadrinhoResponseDTO findById(Long id) {
        Quadrinho quadrinho = quadrinhoRepository.findById(id);
        if(quadrinho == null){
            throw new NotFoundException("Quadrinho não encontrado");
        }
        return new QuadrinhoResponseDTO(quadrinho);
    }

    /*
     ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
    ⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢦⠙⢿⣿⣿⣿⣿⣿⣿⣿
    ⣿⣿⣿⣿⢯⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢃⠛⢿⣿⣿⣿⣿⣿
    ⣿⣿⣿⢧⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡕⠂⠈⢻⣿⣿⣿⣿
    ⣿⣿⡅⣻⡿⢿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠿⢿⣿⡇⠀⠀⠈⣿⣿⣿⣿
    ⣿⣿⠀⠀⠀⠘⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⣹⣿⣿⣿
    ⣿⣿⠀⠀⠀⠀⣿⣿⡿⠿⠛⠻⣿⣿⣿⣿⡿⠟⠁⠈⠀⠉⠻⡆⠀⠀⠀⣿⣿⣿
    ⣿⣯⠄⠂⠀⠀⣿⡋⠀⢀⠀⠀⠀⠉⣿⣿⡀⠀⠀⠘⠓⣠⣶⣿⡀⠀⠀⠘⣿⣿
    ⣿⣫⡆⠀⠀⢀⣿⣷⣶⣄⠀⢀⣤⣴⣿⣿⣿⣶⣄⠀⣴⣿⣿⣿⠁⠀⠀⠀⠘⣿
    ⣿⣿⠁⠀⠀⡤⠙⢿⣿⣿⣷⣾⣿⡿⣿⣿⢿⠿⣿⣧⣿⣿⡿⢣⠀⠀⠀⠀⢠⣿
    ⣷⣌⠈⠀⠀⠀⠀⣆⠈⡉⢹⣿⣿⣆⡀⠀⠀⢠⣿⣿⣿⡿⢃⣼⠀⠀⠀⠀⣸⣿
    ⣿⣿⡇⠀⠀⠀⠀⠙⢿⣿⣆⠈⠛⠛⠛⠀⠀⠈⠉⠁⠀⢠⣿⠇⠀⠀⠀⠹⢿⡇
    ⣿⡫⠀⠀⠁⠀⠀⠀⠈⠻⣿⢢⣄⠀⠀⠀⠀⠀⣀⣠⣾⡾⠋⠀⠀⠀⠀⢀⠴⠋
    ⣿⣁⠄⠀⠀⠀⣀⠀⠀⠀⠈⠛⠿⣿⣿⣿⣿⣿⠿⡿⠋⠀⠀⠀⠀⠀⣀⠬⠆⢀
    ⣿⣿⣧⣄⠀⠀⠉⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠠⠙

     */

    @Override
    @Transactional
    public QuadrinhoResponseDTO create(QuadrinhoDTO quadrinhoDTO) throws ConstraintViolationException{
        validar(quadrinhoDTO);

        Quadrinho entity = new Quadrinho();

        entity.setNome(quadrinhoDTO.nome());
        entity.setEstoque(quadrinhoDTO.estoque());
        entity.setQuantPaginas(quadrinhoDTO.quantPaginas());
        entity.setPreco(quadrinhoDTO.preco());
        entity.setDescricao(quadrinhoDTO.descricao());
        entity.setIdioma(quadrinhoDTO.idioma());
        entity.setEncadernacao(Encadernacao.valueOf(quadrinhoDTO.encadernacao()));
        entity.setEditora(editoraRepository.findById(quadrinhoDTO.editora()));
        // entity.setEncadernacao(quadrinhoDTO.encadernacao());
        
        Autor autor = autorRepository.findById(quadrinhoDTO.autor());
        entity.setAutor(autor);



        quadrinhoRepository.persist(entity);

        return new QuadrinhoResponseDTO(entity);
    }

    @Override
    @Transactional
    public QuadrinhoResponseDTO update(Long id, QuadrinhoDTO quadrinhoDTO) throws ConstraintViolationException{
        validar(quadrinhoDTO);
        
        Quadrinho entity = quadrinhoRepository.findById(id);

        entity.setNome(quadrinhoDTO.nome());
        
        return new QuadrinhoResponseDTO(entity);
    }

    public void validar(QuadrinhoDTO quadrinhoDTO) throws ConstraintViolationException{
        Set<ConstraintViolation<QuadrinhoDTO>> violations = validator.validate(quadrinhoDTO);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id){
        quadrinhoRepository.deleteById(id);
    }

    @Override
    public List<QuadrinhoResponseDTO> findByNome(String nome) {
        List<Quadrinho> list = quadrinhoRepository.findByNome(nome);
        return list.stream().map(QuadrinhoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return quadrinhoRepository.count();
    }

   
    
}