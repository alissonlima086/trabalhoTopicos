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
import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.AutorResponseDTO;
import br.unitins.topicos1.service.AutorService;

@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutorResource {

    @Inject
    AutorService autorService;

    @GET
    public List<AutorResponseDTO> getAll(){
        return autorService.getAll();
    }

    @GET
    @Path("/{id}")
    public AutorResponseDTO findById(@PathParam("id") Long id){
        return autorService.findById(id);
    }

    @POST
    public Response insert(AutorDTO dto){
        try{
            AutorResponseDTO autor = autorService.create(dto);
            return Response.status(Status.CREATED).entity(autor).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, AutorDTO dto){
        try{
            AutorResponseDTO autor = autorService.update(id, dto);
            return Response.ok(autor).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @Delete
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        autorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/Count")
    public Long count(){
        return autorService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<AutorResponseDTO> search(@PathParam("nome") String nome){
        return autorService.findByNome(nome);
    }

}
