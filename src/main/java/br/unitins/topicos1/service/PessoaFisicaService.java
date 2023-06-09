package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PessoaFisicaDTO;
import br.unitins.topicos1.dto.PessoaFisicaResponseDTO;
import br.unitins.topicos1.model.PessoaFisica;

public interface PessoaFisicaService {

    List<PessoaFisicaResponseDTO> getAll();

    PessoaFisicaResponseDTO findById(Long id);

    PessoaFisicaResponseDTO create(PessoaFisicaDTO productDTO);

    PessoaFisicaResponseDTO update(Long id, PessoaFisicaDTO productDTO);

    void delete(Long id);

    // ---------------------------

    List<PessoaFisicaResponseDTO> findByNome(String email);

    long count();

    PessoaFisica createPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO);

}
