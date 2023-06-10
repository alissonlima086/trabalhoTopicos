package br.unitins;



import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import br.unitins.topicos1.repository.QuadrinhoRepository;
import br.unitins.topicos1.service.QuadrinhoService;
import jakarta.inject.Inject;

@QuarkusTest
public class QuadrinhoResourceTest {

    @Inject
    QuadrinhoService quadrinhoService;

    @Inject
    QuadrinhoRepository quadrinhoRepository;
    
    @Test
    @TestSecurity(user = "TestUser", roles = {"Admin", "User"})
    public void testGetAllQuadrinhos(){
        given()
            .when().get("/quadrinhos")
            .then()
                .statusCode(200);
    }



    /*
    @Test
    @TestSecurity(user = "TestUser", roles = "Admin", User)
    public void testInsert(){
        // Inserindo o quadrinho
        QuadrinhoDTO quadrinho = new QuadrinhoDTO(
            "Quadrinho Generico", 
            10, 
            200, 
            60, 
            "Quadrinho generico escrito e desenhado por cicrano", 
            "Portugues", 
            1);
            given().contentType(ContentType.JSON).body(quadrinho)
            .when().post("/quadrinhos")
            .then().statusCode(201)
            .body("id", notNullValue(),
                "nome", is("Quadrinho Generico"),
                "estoque", is(10),
                "quantPaginas", is(200),
                "preco", is(60),
                "descricao", is("Quadrinho generico escrito e desenhado por cicrano"),
                "idioma", is("Portugues"),
                "encadernacao", is(1));
        
    
    }

     */

    
}
