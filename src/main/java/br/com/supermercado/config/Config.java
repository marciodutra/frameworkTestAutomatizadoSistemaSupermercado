package br.com.supermercado.config;


public class Config {


    public static String getBaseUrl(){

        return PropertiesLoader.get("base.url");

    }


    public static String getApiUrl(){

        return PropertiesLoader.get("api.url");

    }


    public static String getLoginEmail(){

        return PropertiesLoader.get("login.email");

    }


    public static String getLoginSenha(){

        return PropertiesLoader.get("login.senha");

    }


}