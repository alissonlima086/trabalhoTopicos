package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.AutorResponseDTO;

public interface AutorService {

    List<AutorResponseDTO> getAll();

    AutorResponseDTO findById(Long id);

    AutorResponseDTO create(AutorDTO autorDTO);

    AutorResponseDTO update(Long id, AutorDTO autorDTO);

    void delete(Long id);

    List<AutorResponseDTO> findByNome(String nome);

    Long count();
    
}