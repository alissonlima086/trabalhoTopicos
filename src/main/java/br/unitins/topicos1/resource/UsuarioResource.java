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
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.UsuarioService;

@Path("/Usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public List<UsuarioResponseDTO> getAll(){
        return usuarioService.getAll();
    }

    @GET
    @Path("/{id}")
    public UsuarioResponseDTO findById(@PathParam("id") Long id){
        return usuarioService.findById(id);
    }

    @POST
    public Response insert(UsuarioDTO dto){
        try{
            UsuarioResponseDTO usuario = usuarioService.create(dto);
            return Response.status(Status.CREATED).entity(usuario).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, UsuarioDTO dto){
        try{
            UsuarioResponseDTO usuario = usuarioService.update(id, dto);
            return Response.ok(usuario).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }
    
    @Delete
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        usuarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{Count}")
    public Long count(){
        return usuarioService.count();
    }

    @GET
    @Path("search/{nome}")
    public List<UsuarioResponseDTO> search(@PathParam("nome") String nome){
        return usuarioService.findByNome(nome);
    }
}
