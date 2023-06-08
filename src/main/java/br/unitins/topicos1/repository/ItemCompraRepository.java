package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.ItemCompra;
import br.unitins.topicos1.model.Quadrinho;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemCompraRepository implements PanacheRepository<ItemCompra> {
    
    public List<ItemCompra> findByProduto (Quadrinho produto) {

        if (produto == null)
            return null;

        return find("FROM ItemCompra WHERE produto = ?1", produto).list();
    }


}
