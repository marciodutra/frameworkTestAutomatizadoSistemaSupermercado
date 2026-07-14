package br.com.supermercado.tests;


import br.com.supermercado.api.ApiClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApiClientTest {


    @Test
    public void deveRetornarUrlDaApi(){


        ApiClient apiClient = new ApiClient();


        String url = apiClient.getBaseUrl();


        System.out.println("API URL: " + url);


        assertEquals(
                "https://supermercado-react.vercel.app",
                url
        );


    }

}