package br.com.supermercado.api.models;

public class Caixa {

    private int id;
    private String data_abertura;
    private String data_fechamento;
    private String valor_abertura;
    private String valor_fechamento;
    private String total_vendas;
    private String status;
    private String dinheiro_contado;
    private String diferenca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(String data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public String getValor_abertura() {
        return valor_abertura;
    }

    public void setValor_abertura(String valor_abertura) {
        this.valor_abertura = valor_abertura;
    }

    public String getValor_fechamento() {
        return valor_fechamento;
    }

    public void setValor_fechamento(String valor_fechamento) {
        this.valor_fechamento = valor_fechamento;
    }

    public String getTotal_vendas() {
        return total_vendas;
    }

    public void setTotal_vendas(String total_vendas) {
        this.total_vendas = total_vendas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDinheiro_contado() {
        return dinheiro_contado;
    }

    public void setDinheiro_contado(String dinheiro_contado) {
        this.dinheiro_contado = dinheiro_contado;
    }

    public String getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(String diferenca) {
        this.diferenca = diferenca;
    }
}