package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.oracle.svm.core.annotate.Delete;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.QuadrinhoDTO;
import br.unitins.topicos1.dto.QuadrinhoResponseDTO;
import br.unitins.topicos1.service.QuadrinhoService;

@Path("/quadrinhos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuadrinhoResource {

    @Inject
    QuadrinhoService quadrinhoService;

    @GET
    public List<QuadrinhoResponseDTO> getAll(){
        return quadrinhoService.getAll();
    }

    @GET
    @Path("/{id}")
    public QuadrinhoResponseDTO findById(@PathParam("id") Long id){
        return quadrinhoService.findById(id);
    }

    @POST
    public Response insert(QuadrinhoDTO dto){
        try{
            QuadrinhoResponseDTO quadrinho = quadrinhoService.create(dto);
            return Response.status(Status.CREATED).entity(quadrinho).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}/update")
    public Response updade(@PathParam("id") Long id, QuadrinhoDTO dto){
        try{
            QuadrinhoResponseDTO quadrinho = quadrinhoService.update(id, dto);
            return Response.ok(quadrinho).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }


    @Delete
    @Path("/{id}/delete")
    public Response delete(@PathParam("id") Long id){
        quadrinhoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
    
    @GET
    @Path("/count")
    public long count(){
        return quadrinhoService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<QuadrinhoResponseDTO> search(@PathParam("nome") String nome){
        return quadrinhoService.findByNome(nome);
    }
    
}
