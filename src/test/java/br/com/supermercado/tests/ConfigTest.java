package br.com.supermercado.tests;

import br.com.supermercado.config.Config;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConfigTest {


    @Test
    public void deveCarregarUrlDoSistema() {


        String url = Config.getBaseUrl();


        System.out.println("URL configurada: " + url);


        assertEquals(
                "https://supermercado-react.vercel.app",
                url
        );

    }

}