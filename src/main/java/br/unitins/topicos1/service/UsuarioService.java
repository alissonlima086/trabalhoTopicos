package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;

public interface UsuarioService {
    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO findById(Long id);

    UsuarioResponseDTO create(UsuarioDTO usuarioDTO);

    UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);

    List<UsuarioResponseDTO> findByNome(String nome);

    Long count();
}
