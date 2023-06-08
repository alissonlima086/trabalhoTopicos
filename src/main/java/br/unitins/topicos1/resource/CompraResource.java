package br.unitins.topicos1.resource;

import java.util.List;
import org.jboss.logging.Logger;
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.CartaoCreditoDTO;
import br.unitins.topicos1.dto.CompraResponseDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.CompraService;
import br.unitins.topicos1.service.UsuarioServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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

    private static final Logger LOG = Logger.getLogger(CompraResource.class);

    @GET
    public List<CompraResponseDTO> getAll() {
        return compraService.getAll();
    }

    @GET
    @Path("/{id}")
    public CompraResponseDTO findById(@PathParam("id") Long id) {
        return compraService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"User"})
    public Response comprarItens() {

        String login = jwt.getSubject();

        UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

        compraService.comprarItens(usuario.id());

        return Response.status(Status.CREATED).build();
        
    }

    @PATCH
    @Path("/carrinho/pagar-pix")
    @RolesAllowed({ "User" })
    public Response pagarPix() {
        Result result = null;

        try {

            String login = jwt.getSubject();

            UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

            compraService.efetuarPagamentoPix(usuario.id());

            LOG.info("Pagamento com pix efetuado com sucesso.");
            return Response.status(Status.ACCEPTED).build();
        } catch (NullPointerException e) {
            LOG.error("Erro ao efetuar o pagamento com pix.", e);
            result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PATCH
    @Path("/carrinho/pagar-cartao-credito")
    @RolesAllowed({ "User" })
    public Response pagarCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {
        Result result = null;

        try {

            String login = jwt.getSubject();

            UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

            compraService.efetuarPagamentoCartaoCredito(usuario.id(), cartaoCreditoDTO);

            LOG.info("Pagamento com cartão de crédito efetuado com sucesso.");
            return Response.status(Status.ACCEPTED).build();
        } catch (NullPointerException e) {
            LOG.error("Erro ao efetuar o pagamento com cartão de crédito.", e);
            result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }
}