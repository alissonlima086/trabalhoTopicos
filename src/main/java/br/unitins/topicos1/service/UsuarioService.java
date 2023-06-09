package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CadastroCompletoDTO;
import br.unitins.topicos1.dto.CadastroSimplesDTO;
import br.unitins.topicos1.dto.DadosLoginDTO;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.ListaDesejoDTO;
import br.unitins.topicos1.dto.ListaDesejoResponseDTO;
import br.unitins.topicos1.dto.SenhaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Usuario;

public interface UsuarioService {

    // recursos basicos
    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO findById(Long id);

    UsuarioResponseDTO create(UsuarioDTO usuarioDTO);

    UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);

    Usuario findByLoginAndSenha(String login, String senha);

    // recursos extras

    void insertListaDesejo(ListaDesejoDTO listaDto);

    ListaDesejoResponseDTO getListaDesejo(Long id);

    List<UsuarioResponseDTO> findByNome(String nome);

    UsuarioResponseDTO findByLogin(String nome);

    public UsuarioResponseDTO update(Long id, String nomeImagem);

    long count();

    public UsuarioResponseDTO create(CadastroSimplesDTO cadastro);

    public UsuarioResponseDTO update(Long id, CadastroCompletoDTO usuarioDTO);

    void update (Long id, DadosLoginDTO dadosPessoaisDTO);

    void update (Long id, SenhaDTO senhaDTO);

    void updateTelefonePrincipal(Long id, TelefoneDTO telefonePrincipalDTO);

    public void updateEndereco(Long id, EnderecoDTO enderecoDTO);

}
