package br.com.supermercado.tests.api;

import br.com.supermercado.api.models.LoginResponse;
import br.com.supermercado.api.services.AuthService;
import br.com.supermercado.config.Config;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import br.com.supermercado.tests.report.listener.ReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ReportExtension.class)
public class LoginApiTest extends BaseApiTest {


    @Test
    public void deveRealizarLoginComSucesso(){

        AuthService authService = new AuthService();

        LoginResponse loginResponse =
                realizarLogin(authService);


        assertNotNull(loginResponse.getToken());

        assertNotNull(loginResponse.getUser());

        assertEquals(
                "Márcio Dutra",
                loginResponse.getUser().getNome()
        );

        assertEquals(
                2,
                loginResponse.getUser().getId()
        );

        assertEquals(
                "admin",
                loginResponse.getUser().getRole()
        );
    }



    private LoginResponse realizarLogin(AuthService authService){

        return authService.login(
                Config.getLoginEmail(),
                Config.getLoginSenha()
        );
    }
}