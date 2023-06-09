/*package br;


import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.dto.QuadrinhoDTO;
import br.unitins.topicos1.service.QuadrinhoService;
import jakarta.inject.Inject;

@QuarkusTest
public class QuadrinhoResourceTest {

    @Inject
    QuadrinhoService quadrinhoService;

    @Test
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


    
}
*/