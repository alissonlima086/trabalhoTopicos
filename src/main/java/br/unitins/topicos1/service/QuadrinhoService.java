package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.QuadrinhoDTO;
import br.unitins.topicos1.dto.QuadrinhoResponseDTO;

public interface QuadrinhoService {

    List<QuadrinhoResponseDTO> getAll();

    QuadrinhoResponseDTO findById(Long id);

    QuadrinhoResponseDTO create(QuadrinhoDTO quadrinhoDTO);

    QuadrinhoResponseDTO update(Long id, QuadrinhoDTO quadrinhoDTO);

    void delete(Long id);

    // ---------

    List<QuadrinhoResponseDTO> findByNome(String nome);

    Long count();
    
}
