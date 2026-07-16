package br.com.supermercado.api.models;

import java.util.List;

public class Dashboard {

    private String vendas_hoje;

    private String quantidade_vendas;

    private String faturamento_total;

    private List<ProdutoMaisVendido> produtos_mais_vendidos;

    private Caixa caixa_aberto;


    public String getVendas_hoje() {
        return vendas_hoje;
    }

    public void setVendas_hoje(String vendas_hoje) {
        this.vendas_hoje = vendas_hoje;
    }


    public String getQuantidade_vendas() {
        return quantidade_vendas;
    }

    public void setQuantidade_vendas(String quantidade_vendas) {
        this.quantidade_vendas = quantidade_vendas;
    }


    public String getFaturamento_total() {
        return faturamento_total;
    }

    public void setFaturamento_total(String faturamento_total) {
        this.faturamento_total = faturamento_total;
    }


    public List<ProdutoMaisVendido> getProdutos_mais_vendidos() {
        return produtos_mais_vendidos;
    }

    public void setProdutos_mais_vendidos(List<ProdutoMaisVendido> produtos_mais_vendidos) {
        this.produtos_mais_vendidos = produtos_mais_vendidos;
    }


    public Caixa getCaixa_aberto() {
        return caixa_aberto;
    }

    public void setCaixa_aberto(Caixa caixa_aberto) {
        this.caixa_aberto = caixa_aberto;
    }

}