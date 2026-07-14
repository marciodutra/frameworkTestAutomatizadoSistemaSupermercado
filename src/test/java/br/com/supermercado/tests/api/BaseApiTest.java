package br.com.supermercado.tests.api;

import br.com.supermercado.api.ServiceFactory;
import br.com.supermercado.api.models.LoginResponse;
import br.com.supermercado.config.Config;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseApiTest {

    protected String token;


    @BeforeEach
    public void autenticar() {

        token = login()
                .getToken();

        assertNotNull(
                token,
                "Token de autenticação não foi gerado"
        );
    }


    @Step("Realizar login com usuário configurado")
    protected LoginResponse login() {

        return ServiceFactory.authService()
                .login(
                        Config.getLoginEmail(),
                        Config.getLoginSenha()
                );
    }
}