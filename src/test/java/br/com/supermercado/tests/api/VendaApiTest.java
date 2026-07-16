package br.com.supermercado.tests.api;

import br.com.supermercado.tests.utils.AssertMessages;

import br.com.supermercado.api.ServiceFactory;
import br.com.supermercado.api.models.Caixa;
import br.com.supermercado.api.models.Produto;
import br.com.supermercado.api.models.VendaResponse;
import br.com.supermercado.tests.report.listener.ReportExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ReportExtension.class)
public class VendaApiTest extends BaseApiTest {


    @Test
    public void deveRegistrarVendaComSucesso() {


        Caixa caixa = ServiceFactory
                .caixaService()
                .abrirCaixa(200, token);


        List<Produto> produtos =
                ServiceFactory
                        .produtoService()
                        .listarProdutos(token);


        Produto produto = produtos.get(0);


        Map<String, Object> item = new HashMap<>();

        item.put("id", produto.getId());
        item.put("nome", produto.getNome());
        item.put("codigo_barras", produto.getCodigo_barras());
        item.put("categoria", produto.getCategoria());
        item.put("preco", produto.getPreco());


        List<Map<String, Object>> itens = new ArrayList<>();

        itens.add(item);


        Map<String, Object> body = new HashMap<>();

        body.put("itens", itens);


        VendaResponse venda =
                ServiceFactory
                        .vendaService()
                        .registrarVenda(body, token);


        assertNotNull(
                venda,
                AssertMessages.RESPOSTA_NAO_DEVE_SER_NULL
        );

        assertEquals(
                "Venda registrada com sucesso!",
                venda.getMensagem(),
                AssertMessages.MENSAGEM_RETORNADA_INCORRETA
        );


        assertTrue(
                venda.getVendaId() > 0,
                AssertMessages.ID_DEVE_SER_MAIOR_QUE_ZERO
        );


        assertEquals(
                caixa.getId(),
                venda.getCaixa_id(),
                AssertMessages.CAIXA_DA_VENDA_INCORRETO
        );


        assertEquals(
                produto.getPreco(),
                venda.getTotal(),
                String.format(
                        "Total da venda inválido. Esperado: %s | Retornado: %s",
                        produto.getPreco(),
                        venda.getTotal()
                )
        );
    }
}