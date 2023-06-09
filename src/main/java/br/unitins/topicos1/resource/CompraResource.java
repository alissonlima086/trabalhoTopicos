package br.unitins.topicos1.resource;

import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.CartaoCreditoDTO;
import br.unitins.topicos1.dto.CompraResponseDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.CompraService;
import br.unitins.topicos1.service.UsuarioServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/compra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

    @Inject
    CompraService compraService;

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioServiceImpl usuarioService;


    @GET
    @RolesAllowed({"Admin", "User"})
    public List<CompraResponseDTO> getAll() {
        return compraService.getAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin","User"})
    public CompraResponseDTO findById(@PathParam("id") Long id) {
        return compraService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Admin","User"})
    @Path("/pagamentopix")
    public Response comprarItensPix() {

        String login = jwt.getSubject();

        UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

        compraService.comprarItensPix(usuario.id());

        return Response.status(Status.CREATED).build();
        
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Admin","User"})
    @Path("/pagamentocartao")
    public Response comprarItensCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {

        String login = jwt.getSubject();

        UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

        compraService.comprarItensCartaoCredito(usuario.id(),cartaoCreditoDTO);

        return Response.status(Status.CREATED).build();
        
    }


}