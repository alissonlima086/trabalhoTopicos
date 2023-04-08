package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.topicos1.model.Quadrinho;
import br.unitins.topicos1.repository.QuadrinhoRepository;

@Path("/quadrinhos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuadrinhoResource {

    @Inject
    private QuadrinhoRepository repository;

    @GET
    public List<Quadrinho> getAll(){
        return repository.findAll().list();

    }

    @POST
    @Transactional
    public Quadrinho insert(Quadrinho quadrinho){
        
        repository.persist(quadrinho);

        return quadrinho;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Quadrinho updade(@PathParam("id") Long id, Quadrinho quadrinho){

        Quadrinho entity = repository.findById(id);

        entity.setNome(quadrinho.getNome());
        entity.setNumeracao(quadrinho.getNumeracao());
        entity.setPreco(quadrinho.getPreco());
        entity.setIdioma(quadrinho.getIdioma());
        entity.setQuantPaginas(quadrinho.getQuantPaginas());
        entity.setSinopse(quadrinho.getSinopse());
        entity.setEncadernacao(quadrinho.getEncadernacao());

        return entity;
    }

    @GET
    @Path("/search/{nome}")
    public List<Quadrinho> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
    
}
