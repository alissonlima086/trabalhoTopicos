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
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.NotFoundException;
import br.unitins.topicos1.dto.CadastroCompletoDTO;
import br.unitins.topicos1.dto.CadastroSimplesDTO;
import br.unitins.topicos1.dto.DadosLoginDTO;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.dto.ListaDesejoDTO;
import br.unitins.topicos1.dto.ListaDesejoResponseDTO;
import br.unitins.topicos1.dto.PessoaFisicaDTO;
import br.unitins.topicos1.dto.SenhaDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.model.PessoaFisica;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.EnderecoRepository;
import br.unitins.topicos1.repository.MunicipioRepository;
import br.unitins.topicos1.repository.PessoaFisicaRepository;
import br.unitins.topicos1.repository.QuadrinhoRepository;
import br.unitins.topicos1.repository.TelefoneRepository;
import br.unitins.topicos1.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    QuadrinhoRepository quadrinhoRepository;

    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    HashService hashService;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    TelefoneRepository telefoneRepository;

    @Inject
    PessoaFisicaRepository pessoaFisicaRepository;

    @Inject
    PessoaFisicaService pessoaFisicaService;

    @Inject
    Validator validator;

    @Override
    public List<UsuarioResponseDTO> getAll() {
        List<Usuario> list = usuarioRepository.listAll();
        return list.stream().map(u -> UsuarioResponseDTO.valueOf(u)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario == null)
            throw new NotFoundException("Usuario não encontrada.");
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        validar(usuarioDTO);

        Usuario entity = new Usuario();
        entity.setLogin(usuarioDTO.login());
        entity.setSenha(hashService.getHashSenha(usuarioDTO.senha()));
        entity.setPessoaFisica(insertPessoaFisica(usuarioDTO.pessoa()));
        entity.setCelular(createTelefone(usuarioDTO.telefone()));
        entity.setEndereco(createEndereco(usuarioDTO.endereco()));

        usuarioRepository.persist(entity);

        return UsuarioResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(CadastroSimplesDTO cadastro) throws ConstraintViolationException {

        Usuario entity = new Usuario();
        // Set<Perfil> perfil = new HashSet<>();
        // perfil.add(Perfil.USER);
        entity.setLogin(cadastro.login());
        entity.setSenha(hashService.getHashSenha(cadastro.senha()));
        entity.addPerfil(Perfil.USER);

        usuarioRepository.persist(entity);

        return UsuarioResponseDTO.valueOf(entity);
    }

    private PessoaFisica insertPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO) throws ConstraintViolationException {

        return pessoaFisicaService.createPessoaFisica(pessoaFisicaDTO);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        validar(usuarioDTO);

        Usuario entity = usuarioRepository.findById(id);
        entity.setLogin(usuarioDTO.login());
        entity.setSenha(usuarioDTO.senha());
        entity.setCelular(createTelefone(usuarioDTO.telefone()));
        entity.setEndereco(createEndereco(usuarioDTO.endereco()));
        entity.setPessoaFisica(createPessoaFisica(usuarioDTO.pessoa()));

        return UsuarioResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, CadastroCompletoDTO cadastro) throws ConstraintViolationException {

        Usuario entity = usuarioRepository.findById(id);
        entity.setEndereco(createEndereco(cadastro.endereco()));
        entity.setPessoaFisica(createPessoaFisica(cadastro.pessoa()));
        entity.setCelular(createTelefone(cadastro.telefone()));

        return UsuarioResponseDTO.valueOf(entity);
    }

    private void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    private void validarTel(TelefoneDTO telefoneDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<TelefoneDTO>> violations = validator.validate(telefoneDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    private void validarPess(PessoaFisicaDTO pessoaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PessoaFisicaDTO>> violations = validator.validate(pessoaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    private void validarEnd(EnderecoDTO enderecoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<EnderecoDTO>> violations = validator.validate(enderecoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        List<Usuario> list = usuarioRepository.findByNome(nome);
        return list.stream().map(u -> UsuarioResponseDTO.valueOf(u)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null)
            throw new NotFoundException("Usuário não encontrado.");
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }

    public ListaDesejoResponseDTO getListaDesejo(Long id) throws NullPointerException {

        Usuario usuario = usuarioRepository.findById(id);

        if (usuario == null)
            throw new NullPointerException("usuario não encontrado");

        return new ListaDesejoResponseDTO(usuario);
    }

    public void insertListaDesejo(ListaDesejoDTO listaDto) throws NullPointerException {

        validarListDe(listaDto);

        Usuario usuario = usuarioRepository.findById(listaDto.idUsuario());

        if (usuario == null){
            throw new NullPointerException("usuario não encontrado");
        }else{
            usuario.setQuadrinhos(quadrinhoRepository.findById(listaDto.idProduto()));
        }
    }

    private void validarListDe(ListaDesejoDTO listaDesejoDto) throws ConstraintViolationException {

        Set<ConstraintViolation<ListaDesejoDTO>> violations = validator.validate(listaDesejoDto);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    private Telefone createTelefone(TelefoneDTO telefone2) throws ConstraintViolationException {
        validarTel(telefone2);

        Telefone telefone = new Telefone();

        telefone.setCodigoArea(telefone2.codigoArea());
        telefone.setNumero(telefone2.numero());

        telefoneRepository.persist(telefone);

        return telefone;
    }

    private PessoaFisica createPessoaFisica(PessoaFisicaDTO pessoa) throws ConstraintViolationException {
        validarPess(pessoa);

        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setNome(pessoa.nome());
        pessoaFisica.setEmail(pessoa.email());
        pessoaFisica.setCpf(pessoa.cpf());
        pessoaFisica.setSexo(Sexo.valueOf(pessoa.sexo()));

        pessoaFisicaRepository.persist(pessoaFisica);

        return pessoaFisica;
    }

    private Endereco createEndereco(EnderecoDTO enderecoDTO) throws ConstraintViolationException {

        validarEnd(enderecoDTO);

        Endereco endereco = new Endereco();
        
        endereco.isPrincipal();

        endereco.setLogradouro(enderecoDTO.logradouro());

        endereco.setBairro(enderecoDTO.bairro());

        endereco.setCep(enderecoDTO.cep());

        endereco.setNumero(enderecoDTO.numero());

        endereco.setComplemento(enderecoDTO.complemento());

        enderecoRepository.persist(endereco);

        return endereco;
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha);
         return usuario;
    }

    @Override
    @Transactional
    public void update(Long id, DadosLoginDTO dadosPessoaisDTO) {

        Usuario entity = usuarioRepository.findById(id);

        entity.getPessoaFisica().setEmail(dadosPessoaisDTO.email());

        entity.getPessoaFisica().setSexo(Sexo.valueOf(dadosPessoaisDTO.sexo()));
    }

    @Override
    public void update(Long id, SenhaDTO senhaDTO) {

        Usuario entity = usuarioRepository.findById(id);

        if (entity.getSenha().equals(hashService.getHashSenha(senhaDTO.senhaAntiga())))
            entity.setSenha(hashService.getHashSenha(senhaDTO.senhaNova()));

        else
            throw new NotAuthorizedException("A senha inserida não corresponde à senha atual, acesso negado");
    }

    @Override
    @Transactional
    public void updateTelefonePrincipal(Long id, TelefoneDTO telefonePrincipalDTO) {

        Usuario entity = usuarioRepository.findById(id);

        Long idTelefone = entity.getCelular().getId();

        entity.setCelular(createTelefone(telefonePrincipalDTO));

        deleteTelefone(idTelefone);
    }

    private void deleteTelefone(Long id) throws NotFoundException, IllegalArgumentException {

        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Telefone telefone = telefoneRepository.findById(id);

        if (telefoneRepository.isPersistent(telefone))
            telefoneRepository.delete(telefone);

        else
            throw new NotFoundException("Nenhum Telefone encontrado");
    }

    @Override
    @Transactional
    public void updateEndereco(Long id, EnderecoDTO enderecoDTO) {

        Usuario entity = usuarioRepository.findById(id);
        Long idEndereco = entity.getEndereco().getId();

        entity.setEndereco(createEndereco(enderecoDTO));
        deleteEndereco(idEndereco);

    }
    
    private void deleteEndereco(Long id) throws NotFoundException, IllegalArgumentException {

        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Endereco endereco = enderecoRepository.findById(id);

        if (enderecoRepository.isPersistent(endereco))
            enderecoRepository.delete(endereco);

        else
            throw new NotFoundException("Nenhum Endereco encontrado");
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, String nomeImagem) {
   
        Usuario entity = usuarioRepository.findById(id);
        entity.setNomeImagem(nomeImagem);

        return UsuarioResponseDTO.valueOf(entity);
    }

}
