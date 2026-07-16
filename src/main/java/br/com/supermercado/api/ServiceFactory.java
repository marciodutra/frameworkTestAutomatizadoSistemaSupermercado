package br.com.supermercado.api;

import br.com.supermercado.api.services.AuthService;
import br.com.supermercado.api.services.CaixaService;
import br.com.supermercado.api.services.ProdutoService;
import br.com.supermercado.api.services.VendaService;

public class ServiceFactory {

    public static AuthService authService() {
        return new AuthService();
    }

    public static ProdutoService produtoService() {
        return new ProdutoService();
    }

    public static CaixaService caixaService() {
        return new CaixaService();
    }

    public static VendaService vendaService() {
        return new VendaService();
    }

}