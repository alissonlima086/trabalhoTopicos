package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.ItemCompra;
import br.unitins.topicos1.model.Quadrinho;
import br.unitins.topicos1.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemCompraRepository implements PanacheRepository<ItemCompra> {
    
    public List<ItemCompra> findByProduto (Quadrinho quadrinho) {

        if (quadrinho == null)
            return null;

        return find("FROM ItemCompra WHERE produto = ?1", quadrinho).list();
    }

    public List<ItemCompra> findItemCompraByUsuario (Usuario usuario) {

        if (usuario == null)
            return null;

            boolean item = false;

        return find("FROM ItemCompra WHERE usuario = ?1 AND idComprado = ?2", usuario,item).list();
    }

}
