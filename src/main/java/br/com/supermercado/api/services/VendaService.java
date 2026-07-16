package br.com.supermercado.api.services;

import br.com.supermercado.api.models.VendaResponse;
import br.com.supermercado.config.Config;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class VendaService {

    public VendaResponse registrarVenda(
            Map<String, Object> body,
            String token
    ) {

        return given()

                .baseUri(Config.getApiUrl())

                .header(
                        "Authorization",
                        "Bearer " + token
                )

                .contentType("application/json")

                .body(body)

                .when()

                .post("/vendas")

                .then()

                .statusCode(200)

                .extract()

                .as(VendaResponse.class);
    }
}