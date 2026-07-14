package br.com.supermercado.api.services;


import br.com.supermercado.api.models.LoginResponse;
import br.com.supermercado.config.Config;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class AuthService {


    public LoginResponse login(String email, String senha){


        Response response =

                given()

                        .baseUri(Config.getApiUrl())

                        .contentType("application/json")

                        .body("""
                        {
                          "email": "%s",
                          "senha": "%s"
                        }
                        """.formatted(email, senha))

                        .when()

                        .post("/auth/login");


        return response.as(LoginResponse.class);


    }


}