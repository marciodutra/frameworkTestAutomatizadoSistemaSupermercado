package br.com.supermercado.api.models;

public class ProdutoMaisVendido {

    private String nome;

    private String total;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}