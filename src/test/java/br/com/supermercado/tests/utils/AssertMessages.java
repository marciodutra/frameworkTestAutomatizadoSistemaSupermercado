package br.com.supermercado.tests.utils;

public final class AssertMessages {

    private AssertMessages() {
    }

    public static final String RESPOSTA_NAO_DEVE_SER_NULL =
            "A resposta da API não deve ser nula.";

    public static final String LISTA_PRODUTOS_VAZIA =
            "A lista de produtos não deve estar vazia.";

    public static final String ID_DEVE_SER_MAIOR_QUE_ZERO =
            "O identificador retornado deve ser maior que zero.";

    public static final String MENSAGEM_RETORNADA_INCORRETA =
            "A mensagem retornada pela API é diferente da esperada.";

    public static final String TOTAL_DA_VENDA_INCORRETO =
            "O total retornado pela API deve ser igual ao total da venda.";

    public static final String CAIXA_DA_VENDA_INCORRETO =
            "O caixa retornado na venda deve ser o mesmo caixa aberto.";

    public static final String NOME_PRODUTO_INCORRETO =
            "O nome do produto retornado é diferente do esperado.";

    public static final String PRECO_PRODUTO_INCORRETO =
            "O preço do produto retornado é diferente do esperado.";

    public static final String ESTOQUE_PRODUTO_INCORRETO =
            "O estoque retornado é diferente do esperado.";
}