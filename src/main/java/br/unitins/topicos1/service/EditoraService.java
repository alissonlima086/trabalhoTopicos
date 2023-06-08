package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.dto.EditoraResponseDTO;

public interface EditoraService {
    List<EditoraResponseDTO> getAll();

    EditoraResponseDTO findById(Long id);

    EditoraResponseDTO create(EditoraDTO editoraDTO);

    EditoraResponseDTO update(Long id, EditoraDTO editoraDTO);

    void delete(Long id);

    // ---------

    List<EditoraResponseDTO> findByNome(String nome);

    Long count();
    
}
