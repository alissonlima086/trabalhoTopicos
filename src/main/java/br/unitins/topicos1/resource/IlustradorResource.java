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
import br.unitins.topicos1.dto.IlustradorDTO;
import br.unitins.topicos1.dto.IlustradorResponseDTO;
import br.unitins.topicos1.service.IlustradorService;

@Path("/ilustradores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IlustradorResource {

    @Inject
    IlustradorService ilustradorService;

    @GET
    public List<IlustradorResponseDTO> getAll(){
        return ilustradorService.getAll();
    }

    @GET
    @Path("/{id}")
    public IlustradorResponseDTO findById(@PathParam("id") Long id){
        return ilustradorService.findById(id);
    }

    @POST
    public Response insert(IlustradorDTO dto){
        try{
            IlustradorResponseDTO ilustrador = ilustradorService.create(dto);
            return Response.status(Status.CREATED).entity(ilustrador).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("`{id}")
    public Response update(@PathParam("id") Long id, IlustradorDTO dto){
        try{
            IlustradorResponseDTO ilustrador = ilustradorService.update(id, dto);
            return Response.ok(ilustrador).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @Delete
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        ilustradorService.delete(id);
        return Response.status((Status.NO_CONTENT)).build();
    }

    @GET
    @Path("/Count")
    public Long count(){
        return ilustradorService.count();
    }

    @GET
    @Path("search/{nome}")
    public List<IlustradorResponseDTO> search(@PathParam("nome") String nome){
        return ilustradorService.findByNome(nome);
    }
}

