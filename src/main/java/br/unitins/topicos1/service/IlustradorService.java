package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.IlustradorDTO;
import br.unitins.topicos1.dto.IlustradorResponseDTO;

public interface IlustradorService {

    List<IlustradorResponseDTO> getAll();

    IlustradorResponseDTO findById(Long id);

    IlustradorResponseDTO create(IlustradorDTO ilustradorDTO);

    IlustradorResponseDTO update(Long id, IlustradorDTO ilustradorDTO);

    void delete(Long id);

    List<IlustradorResponseDTO> findByNome(String nome);

    Long count();
    
}
