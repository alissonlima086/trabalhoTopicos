package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.ItemCompraDTO;
import br.unitins.topicos1.dto.ItemCompraResponseDTO;
import br.unitins.topicos1.model.ItemCompra;
import br.unitins.topicos1.model.Quadrinho;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.ItemCompraRepository;
import br.unitins.topicos1.repository.QuadrinhoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ItemCompraServiceImpl implements ItemCompraService{
    
    @Inject
    ItemCompraRepository itemCompraRepository;

    @Inject
    QuadrinhoRepository quadrinhoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<ItemCompraResponseDTO> getAll() {
        List<ItemCompra> list = itemCompraRepository.listAll();
        return list.stream().map(ItemCompraResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ItemCompraResponseDTO findById(Long id) {
        ItemCompra ItemCompra = itemCompraRepository.findById(id);
        if (ItemCompra == null)
            throw new NotFoundException("ItemCompra não encontrada.");
        return new ItemCompraResponseDTO(ItemCompra);
    }

    @Override
    @Transactional
    public ItemCompraResponseDTO create2(Long idUsuario, ItemCompraDTO itemCompraDTO) throws ConstraintViolationException {

        ItemCompra entity = new ItemCompra();
        Quadrinho quadrinho = quadrinhoRepository.findById(itemCompraDTO.idProduto());
        if(itemCompraDTO.quant() > quadrinho.getEstoque()){
            throw new NotFoundException("Produto sem Estoque");
        }

        quadrinho.setEstoque(quadrinho.getEstoque()-itemCompraDTO.quant());

        entity.setQuant(itemCompraDTO.quant());
        entity.setProduto(quadrinhoRepository.findById(itemCompraDTO.idProduto()));
        entity.setUsuario(usuarioRepository.findById(idUsuario));
        entity.setTotalItem(entity.getProduto().getPreco() * entity.getQuant());

        itemCompraRepository.persist(entity);

        return new ItemCompraResponseDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long idUsuario, Long idItem) {

        ItemCompra entity = itemCompraRepository.findById(idItem);

        if(entity.getUsuario().getId() == idUsuario){
            itemCompraRepository.deleteById(idItem);
        }
        else
            throw new NotAuthorizedException("Você não pode excluir items de outros usuarios");
    }

    @Override
    public long count() {
        return itemCompraRepository.count();
    }

    @Override
    public long countItemCompra(Long id) throws NullPointerException {
        long cont = itemCompraRepository.count();
        long cont2 = 0;
        Usuario usuario = usuarioRepository.findById(id);

        if (usuario == null)
            throw new NullPointerException("usuario não encontrado");

            while(cont > 0){
                ItemCompra item = itemCompraRepository.findById(cont);
                if (item.getUsuario().getId() == id){
                    cont2 ++;
                }
                cont--;
            }
        return cont2;
    }
    }

