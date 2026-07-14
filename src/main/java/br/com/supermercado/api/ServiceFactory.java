package br.com.supermercado.api;

import br.com.supermercado.api.services.AuthService;
import br.com.supermercado.api.services.ProdutoService;

public class ServiceFactory {

    public static AuthService authService() {
        return new AuthService();
    }

    public static ProdutoService produtoService() {
        return new ProdutoService();
    }

}