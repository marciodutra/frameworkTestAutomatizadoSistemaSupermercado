package br.com.supermercado.api;


import br.com.supermercado.config.Config;


public class ApiClient {


    public String getBaseUrl(){

        return Config.getBaseUrl();

    }


}